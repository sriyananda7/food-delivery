package com.bytebites.restaurant_service.dto;

public class MenuItemSummaryResponse {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean available;

    public MenuItemSummaryResponse(Long id,
                                   String name,
                                   String description,
                                   Double price,
                                   Boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getAvailable() {
        return available;
    }
}