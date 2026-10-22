package com.bytebites.restaurant_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bytebites.restaurant_service.dto.MenuItemRequest;
import com.bytebites.restaurant_service.dto.MenuItemResponse;
import com.bytebites.restaurant_service.dto.MenuItemSummaryResponse;
import com.bytebites.restaurant_service.service.MenuItemService;

@RestController
@RequestMapping("/api/v1/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public MenuItemResponse addMenuItem(@RequestBody MenuItemRequest request) {
        return menuItemService.addMenuItem(request);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItemSummaryResponse> getMenuByRestaurant(
            @PathVariable Long restaurantId) {

        return menuItemService.getMenuByRestaurant(restaurantId);
    }
}