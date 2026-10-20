package com.bytebites.food_delivery.dto;

public class CartItemSummaryResponse {

    private Long id;
    private String itemName;
    private Integer quantity;
    private Double price;

    public CartItemSummaryResponse(Long id,
                                   String itemName,
                                   Integer quantity,
                                   Double price) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
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