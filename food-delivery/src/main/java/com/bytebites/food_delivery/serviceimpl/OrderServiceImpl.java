package com.bytebites.food_delivery.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytebites.food_delivery.dto.OrderResponse;
import com.bytebites.food_delivery.dto.OrderSummaryResponse;
import com.bytebites.food_delivery.dto.PlaceOrderRequest;
import com.bytebites.food_delivery.dto.UpdateOrderStatusRequest;
import com.bytebites.food_delivery.entity.CartItem;
import com.bytebites.food_delivery.entity.Order;
import com.bytebites.food_delivery.entity.OrderItem;
import com.bytebites.food_delivery.entity.OrderStatus;
import com.bytebites.food_delivery.entity.User;
import com.bytebites.food_delivery.repository.CartItemRepository;
import com.bytebites.food_delivery.repository.OrderItemRepository;
import com.bytebites.food_delivery.repository.OrderRepository;
import com.bytebites.food_delivery.repository.UserRepository;
import com.bytebites.food_delivery.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderItemRepository orderItemRepository,
                            CartItemRepository cartItemRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(PlaceOrderRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<CartItem> cartItems = cartItemRepository.findByUserId(user.getId());

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        double total = 0;

        for (CartItem cartItem : cartItems) {
            total += cartItem.getQuantity()
                    * cartItem.getMenuItem().getPrice();
        }

        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PLACED);
        order.setCreatedAt(LocalDateTime.now());
        order.setTotalAmount(total);

        Order savedOrder = orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(savedOrder);
            orderItem.setMenuItem(cartItem.getMenuItem());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPriceAtPurchase(
                    cartItem.getMenuItem().getPrice());

            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);

        cartItemRepository.deleteAll(cartItems);

        return new OrderResponse(
                savedOrder.getId(),
                "Order placed successfully");
    }

    @Override
    public List<OrderSummaryResponse> getOrders(Long userId) {

        return orderRepository.findByUserId(userId)
                .stream()
                .map(order -> new OrderSummaryResponse(
                        order.getId(),
                        order.getTotalAmount(),
                        order.getStatus(),
                        order.getCreatedAt()
                ))
                .toList();
    }

    @Override
    public OrderResponse updateOrderStatus(Long orderId,
                                           UpdateOrderStatusRequest request) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(request.getStatus());

        orderRepository.save(order);

        return new OrderResponse(
                order.getId(),
                "Order status updated successfully");
    }
}