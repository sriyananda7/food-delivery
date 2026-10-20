package com.bytebites.food_delivery.dto;

public class CartItemResponse {

    private Long id;
    private String message;

    public CartItemResponse(Long id, String message) {
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