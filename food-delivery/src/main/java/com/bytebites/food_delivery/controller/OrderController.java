package com.bytebites.food_delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bytebites.food_delivery.dto.OrderResponse;
import com.bytebites.food_delivery.dto.OrderSummaryResponse;
import com.bytebites.food_delivery.dto.PlaceOrderRequest;
import com.bytebites.food_delivery.dto.UpdateOrderStatusRequest;
import com.bytebites.food_delivery.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse placeOrder(@RequestBody PlaceOrderRequest request) {
        return orderService.placeOrder(request);
    }

    @GetMapping("/user/{userId}")
    public List<OrderSummaryResponse> getOrders(@PathVariable Long userId) {
        return orderService.getOrders(userId);
    }

    @PatchMapping("/{orderId}/status")
    public OrderResponse updateOrderStatus(
            @PathVariable Long orderId,
            @RequestBody UpdateOrderStatusRequest request) {

        return orderService.updateOrderStatus(orderId, request);
    }
}