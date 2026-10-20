package com.bytebites.food_delivery.dto;

public class OrderItemResponse {

    private String itemName;
    private Integer quantity;
    private Double price;

    public OrderItemResponse(String itemName,
                             Integer quantity,
                             Double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}