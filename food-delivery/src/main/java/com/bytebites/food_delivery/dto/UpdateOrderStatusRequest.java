package com.bytebites.food_delivery.dto;

import com.bytebites.food_delivery.entity.OrderStatus;

public class UpdateOrderStatusRequest {

    private OrderStatus status;

    public UpdateOrderStatusRequest() {
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}