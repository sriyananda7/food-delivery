package com.bytebites.food_delivery.service;

import java.util.List;

import com.bytebites.food_delivery.dto.RestaurantRequest;
import com.bytebites.food_delivery.dto.RestaurantResponse;
import com.bytebites.food_delivery.dto.RestaurantSummaryResponse;

public interface RestaurantService {

    RestaurantResponse addRestaurant(RestaurantRequest request);

    List<RestaurantSummaryResponse> getAllRestaurants();
}