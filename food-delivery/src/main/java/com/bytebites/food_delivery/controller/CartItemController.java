package com.bytebites.food_delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bytebites.food_delivery.dto.CartItemRequest;
import com.bytebites.food_delivery.dto.CartItemResponse;
import com.bytebites.food_delivery.dto.CartItemSummaryResponse;
import com.bytebites.food_delivery.service.CartItemService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public CartItemResponse addToCart(@RequestBody CartItemRequest request) {
        return cartItemService.addToCart(request);
    }

    @GetMapping("/{userId}")
    public List<CartItemSummaryResponse> getCart(@PathVariable Long userId) {
        return cartItemService.getCart(userId);
    }
}