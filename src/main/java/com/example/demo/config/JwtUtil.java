package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component   // ✅ THIS IS THE KEY FIX
public class JwtUtil {

    private final Key key;
    private final long validityMs;

    public JwtUtil() {
        // secret must be at least 32 chars
        String secret = "my-secret-key-my-secret-key-my-secret-key";
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityMs = 86400000; // 1 day
    }

    public String generateToken(String email, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityMs);

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key)
                .compact();
    }

    public Claims validateAndParse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
