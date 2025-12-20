package com.example.demo.config;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "secret-key";
    private final int expiry = 3600000;

    public JwtUtil() {
    }

    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String generateToken(User user) {
        return generateToken(user.getEmail(), user.getRole().name());
    }
}
