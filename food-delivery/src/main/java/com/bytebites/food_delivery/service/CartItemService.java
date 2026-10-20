package com.bytebites.food_delivery.service;

import java.util.List;

import com.bytebites.food_delivery.dto.CartItemRequest;
import com.bytebites.food_delivery.dto.CartItemResponse;
import com.bytebites.food_delivery.dto.CartItemSummaryResponse;

public interface CartItemService {

    CartItemResponse addToCart(CartItemRequest request);

    List<CartItemSummaryResponse> getCart(Long userId);
}