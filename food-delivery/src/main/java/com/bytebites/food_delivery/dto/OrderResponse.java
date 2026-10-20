package com.bytebites.food_delivery.dto;

public class OrderResponse {

    private Long id;
    private String message;

    public OrderResponse(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}