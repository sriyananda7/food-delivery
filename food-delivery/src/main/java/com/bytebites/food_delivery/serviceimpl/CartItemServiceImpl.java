package com.bytebites.food_delivery.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytebites.food_delivery.dto.CartItemRequest;
import com.bytebites.food_delivery.dto.CartItemResponse;
import com.bytebites.food_delivery.dto.CartItemSummaryResponse;
import com.bytebites.food_delivery.entity.CartItem;
import com.bytebites.food_delivery.entity.MenuItem;
import com.bytebites.food_delivery.entity.User;
import com.bytebites.food_delivery.repository.CartItemRepository;
import com.bytebites.food_delivery.repository.MenuItemRepository;
import com.bytebites.food_delivery.repository.UserRepository;
import com.bytebites.food_delivery.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final MenuItemRepository menuItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository,
                               UserRepository userRepository,
                               MenuItemRepository menuItemRepository) {
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public CartItemResponse addToCart(CartItemRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        MenuItem menuItem = menuItemRepository.findById(request.getMenuItemId())
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        CartItem cartItem = new CartItem();
        cartItem.setUser(user);
        cartItem.setMenuItem(menuItem);
        cartItem.setQuantity(request.getQuantity());

        CartItem savedCartItem = cartItemRepository.save(cartItem);

        return new CartItemResponse(
                savedCartItem.getId(),
                "Item added to cart"
        );
    }

    @Override
    public List<CartItemSummaryResponse> getCart(Long userId) {

        return cartItemRepository.findByUserId(userId)
                .stream()
                .map(cartItem -> new CartItemSummaryResponse(
                        cartItem.getId(),
                        cartItem.getMenuItem().getName(),
                        cartItem.getQuantity(),
                        cartItem.getMenuItem().getPrice()
                ))
                .toList();
    }
}