package com.bytebites.restaurant_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bytebites.restaurant_service.dto.RestaurantRequest;
import com.bytebites.restaurant_service.dto.RestaurantResponse;
import com.bytebites.restaurant_service.dto.RestaurantSummaryResponse;
import com.bytebites.restaurant_service.service.RestaurantService;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public RestaurantResponse addRestaurant(@RequestBody RestaurantRequest request) {
        return restaurantService.addRestaurant(request);
    }

    @GetMapping
    public List<RestaurantSummaryResponse> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
}