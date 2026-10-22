package com.bytebites.restaurant_service.dto;

public class MenuItemResponse {

    private Long id;
    private String message;

    public MenuItemResponse(Long id, String message) {
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