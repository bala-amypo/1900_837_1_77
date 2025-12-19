package com.example.demo.service;

public interface AuthService {
    void register(String name, String email, String password);
    String login(String email, String password);
}
