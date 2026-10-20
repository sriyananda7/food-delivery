package com.bytebites.food_delivery.service;

import java.util.List;

import com.bytebites.food_delivery.dto.OrderResponse;
import com.bytebites.food_delivery.dto.OrderSummaryResponse;
import com.bytebites.food_delivery.dto.PlaceOrderRequest;
import com.bytebites.food_delivery.dto.UpdateOrderStatusRequest;

public interface OrderService {

    OrderResponse placeOrder(PlaceOrderRequest request);

    List<OrderSummaryResponse> getOrders(Long userId);

    OrderResponse updateOrderStatus(Long orderId,
                                    UpdateOrderStatusRequest request);
}