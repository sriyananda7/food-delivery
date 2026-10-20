package com.bytebites.food_delivery.dto;

import java.time.LocalDateTime;

import com.bytebites.food_delivery.entity.OrderStatus;

public class OrderSummaryResponse {

    private Long id;
    private Double totalAmount;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public OrderSummaryResponse(Long id,
                                Double totalAmount,
                                OrderStatus status,
                                LocalDateTime createdAt) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}