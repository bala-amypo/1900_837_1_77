package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface AuthService {

    UserEntity register(UserEntity user);

    UserEntity getById(Long id);

    UserEntity findByEmail(String email);
}
