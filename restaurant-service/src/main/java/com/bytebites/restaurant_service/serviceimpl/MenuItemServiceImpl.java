package com.bytebites.restaurant_service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytebites.restaurant_service.dto.MenuItemRequest;
import com.bytebites.restaurant_service.dto.MenuItemResponse;
import com.bytebites.restaurant_service.dto.MenuItemSummaryResponse;
import com.bytebites.restaurant_service.entity.MenuItem;
import com.bytebites.restaurant_service.entity.Restaurant;
import com.bytebites.restaurant_service.repository.MenuItemRepository;
import com.bytebites.restaurant_service.repository.RestaurantRepository;
import com.bytebites.restaurant_service.service.MenuItemService;

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