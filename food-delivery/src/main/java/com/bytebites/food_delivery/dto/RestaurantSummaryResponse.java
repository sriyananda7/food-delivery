package com.bytebites.food_delivery.dto;

public class RestaurantSummaryResponse {

    private Long id;
    private String name;
    private String address;
    private Double rating;

    public RestaurantSummaryResponse(Long id, String name, String address, Double rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getRating() {
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}