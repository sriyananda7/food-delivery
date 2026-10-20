package com.bytebites.food_delivery.serviceimpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bytebites.food_delivery.dto.LoginRequest;
import com.bytebites.food_delivery.dto.LoginResponse;
import com.bytebites.food_delivery.dto.RegisterRequest;
import com.bytebites.food_delivery.dto.RegisterResponse;
import com.bytebites.food_delivery.entity.User;
import com.bytebites.food_delivery.repository.UserRepository;
import com.bytebites.food_delivery.service.JwtService;
import com.bytebites.food_delivery.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

   public UserServiceImpl(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,JwtService jwtService) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService=jwtService;
}

    @Override
    public RegisterResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
    throw new RuntimeException("Email already exists");
}
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);

        return new RegisterResponse(
                savedUser.getId(),
                "User registered successfully"
        );
    }

    @Override
    public LoginResponse login(LoginRequest request) {

    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Invalid credentials"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }

    // JWT generation later
String token = jwtService.generateToken(user);
return new LoginResponse(token);}
}
