package com.bytebites.food_delivery.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytebites.food_delivery.dto.MenuItemRequest;
import com.bytebites.food_delivery.dto.MenuItemResponse;
import com.bytebites.food_delivery.dto.MenuItemSummaryResponse;
import com.bytebites.food_delivery.entity.MenuItem;
import com.bytebites.food_delivery.entity.Restaurant;
import com.bytebites.food_delivery.repository.MenuItemRepository;
import com.bytebites.food_delivery.repository.RestaurantRepository;
import com.bytebites.food_delivery.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository,
                               RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public MenuItemResponse addMenuItem(MenuItemRequest request) {

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        MenuItem menuItem = new MenuItem();

        menuItem.setName(request.getName());
        menuItem.setDescription(request.getDescription());
        menuItem.setPrice(request.getPrice());
        menuItem.setAvailable(request.getAvailable());
        menuItem.setRestaurant(restaurant);

        MenuItem savedMenuItem = menuItemRepository.save(menuItem);

        return new MenuItemResponse(
                savedMenuItem.getId(),
                "Menu item added successfully"
        );
    }

    @Override
    public List<MenuItemSummaryResponse> getMenuByRestaurant(Long restaurantId) {

        return menuItemRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(menuItem -> new MenuItemSummaryResponse(
                        menuItem.getId(),
                        menuItem.getName(),
                        menuItem.getDescription(),
                        menuItem.getPrice(),
                        menuItem.getAvailable()
                ))
                .toList();
    }
}