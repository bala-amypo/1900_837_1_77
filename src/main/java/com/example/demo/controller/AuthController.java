package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.AuthService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) {
        return ResponseEntity.ok(service.register(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
