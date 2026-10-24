package com.bytebites.restaurant_service.controller;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import com.bytebites.restaurant_service.dto.RestaurantRequest;
import com.bytebites.restaurant_service.dto.RestaurantResponse;
import com.bytebites.restaurant_service.dto.RestaurantSummaryResponse;
import com.bytebites.restaurant_service.service.RestaurantService;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final Environment environment;

    public RestaurantController(RestaurantService restaurantService, Environment environment) {
        this.restaurantService = restaurantService;
        this.environment = environment;
    }

    @PostMapping
    public RestaurantResponse addRestaurant(@RequestBody RestaurantRequest request) {
        return restaurantService.addRestaurant(request);
    }

    @GetMapping
    public List<RestaurantSummaryResponse> getAllRestaurants() {
        System.out.println("Request handled by port " + environment.getProperty("local.server.port"));

        return restaurantService.getAllRestaurants();
    }
}