package com.bytebites.food_delivery.service;

import java.util.List;

import com.bytebites.food_delivery.dto.MenuItemRequest;
import com.bytebites.food_delivery.dto.MenuItemResponse;
import com.bytebites.food_delivery.dto.MenuItemSummaryResponse;

public interface MenuItemService {

    MenuItemResponse addMenuItem(MenuItemRequest request);

    List<MenuItemSummaryResponse> getMenuByRestaurant(Long restaurantId);
}