package com.example.demo.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import com.example.demo.entity.User;

public class JwtUtil {

    private final SecretKey key;
    private final long validityMs;

    public JwtUtil(String secret, long validityMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityMs = validityMs;
    }

    public String generateToken(User user) {

        return Jwts.builder()
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole().name())
                .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                .signWith(key)
                .compact();
    }

    public Jws<Claims> validateAndParse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
