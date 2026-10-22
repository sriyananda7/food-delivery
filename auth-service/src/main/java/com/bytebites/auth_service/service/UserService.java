package com.bytebites.auth_service.service;

import com.bytebites.auth_service.dto.LoginRequest;
import com.bytebites.auth_service.dto.LoginResponse;
import com.bytebites.auth_service.dto.RegisterRequest;
import com.bytebites.auth_service.dto.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}