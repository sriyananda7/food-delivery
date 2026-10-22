package com.bytebites.restaurant_service.service;

import java.util.List;

import com.bytebites.restaurant_service.dto.RestaurantRequest;
import com.bytebites.restaurant_service.dto.RestaurantResponse;
import com.bytebites.restaurant_service.dto.RestaurantSummaryResponse;

public interface RestaurantService {

    RestaurantResponse addRestaurant(RestaurantRequest request);

    List<RestaurantSummaryResponse> getAllRestaurants();
}