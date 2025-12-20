package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String secret;

    // Inject the value of jwt.secret from application.properties
    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    // Example JWT method
    public String generateToken(String username) {
        // implementation to generate token using 'secret'
        return "token-for-" + username; // placeholder
    }
}
