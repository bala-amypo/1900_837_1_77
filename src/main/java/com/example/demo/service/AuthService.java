package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface AuthService {

    UserEntity register(RegisterRequest request);

    String login(LoginRequest request);
}
