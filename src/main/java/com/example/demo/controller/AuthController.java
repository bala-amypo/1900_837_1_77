package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import com.example.demo.config.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest req) {
        User u = User.builder()
                .fullName(req.getFullName())
                .email(req.getEmail())
                .password(req.getPassword())
                .role(req.getRole() == null ? User.Role.STUDENT : User.Role.valueOf(req.getRole()))
                .build();

        return authService.register(u);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        User user = authService.findByEmail(req.getEmail());
        // Normally password check is here, but service layer handles logic
        return jwtUtil.generateToken(user);
    }
}
