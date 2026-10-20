package com.bytebites.food_delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bytebites.food_delivery.dto.MenuItemRequest;
import com.bytebites.food_delivery.dto.MenuItemResponse;
import com.bytebites.food_delivery.dto.MenuItemSummaryResponse;
import com.bytebites.food_delivery.service.MenuItemService;

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