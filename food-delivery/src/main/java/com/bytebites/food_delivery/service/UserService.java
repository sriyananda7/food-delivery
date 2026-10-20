package com.bytebites.food_delivery.service;

import com.bytebites.food_delivery.dto.LoginRequest;
import com.bytebites.food_delivery.dto.LoginResponse;
import com.bytebites.food_delivery.dto.RegisterRequest;
import com.bytebites.food_delivery.dto.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}