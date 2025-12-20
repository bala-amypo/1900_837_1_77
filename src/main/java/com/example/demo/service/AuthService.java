package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;

public interface AuthService {

    Object register(RegisterRequest request);

    Object login(LoginRequest request);
}
