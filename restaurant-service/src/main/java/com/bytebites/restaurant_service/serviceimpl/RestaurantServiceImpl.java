package com.bytebites.restaurant_service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytebites.restaurant_service.dto.RestaurantRequest;
import com.bytebites.restaurant_service.dto.RestaurantResponse;
import com.bytebites.restaurant_service.dto.RestaurantSummaryResponse;
import com.bytebites.restaurant_service.entity.Restaurant;
import com.bytebites.restaurant_service.repository.RestaurantRepository;
import com.bytebites.restaurant_service.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantResponse addRestaurant(RestaurantRequest request) {

        Restaurant restaurant = new Restaurant();

        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setPhone(request.getPhone());
        restaurant.setRating(0.0);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return new RestaurantResponse(
                savedRestaurant.getId(),
                "Restaurant added successfully"
        );
    }

    @Override
    public List<RestaurantSummaryResponse> getAllRestaurants() {

        return restaurantRepository.findAll()
                .stream()
                .map(restaurant -> new RestaurantSummaryResponse(
                        restaurant.getId(),
                        restaurant.getName(),
                        restaurant.getAddress(),
                        restaurant.getRating()
                ))
                .toList();
    }
}