package com.bytebites.restaurant_service.service;

import java.util.List;

import com.bytebites.restaurant_service.dto.MenuItemRequest;
import com.bytebites.restaurant_service.dto.MenuItemResponse;
import com.bytebites.restaurant_service.dto.MenuItemSummaryResponse;

public interface MenuItemService {

    MenuItemResponse addMenuItem(MenuItemRequest request);

    List<MenuItemSummaryResponse> getMenuByRestaurant(Long restaurantId);
}