package com.bytebites.food_delivery.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytebites.food_delivery.dto.RestaurantRequest;
import com.bytebites.food_delivery.dto.RestaurantResponse;
import com.bytebites.food_delivery.dto.RestaurantSummaryResponse;
import com.bytebites.food_delivery.entity.Restaurant;
import com.bytebites.food_delivery.repository.RestaurantRepository;
import com.bytebites.food_delivery.service.RestaurantService;

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