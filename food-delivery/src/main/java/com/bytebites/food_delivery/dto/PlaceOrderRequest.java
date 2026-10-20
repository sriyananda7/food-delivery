package com.bytebites.food_delivery.dto;

public class PlaceOrderRequest {

    private Long userId;

    public PlaceOrderRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}