package com.example.demo.config;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtil {
    private final String secret;
    private final long validityMs;

    public JwtUtil(String secret, long validityMs) {
        this.secret = secret;
        this.validityMs = validityMs;
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public void validateAndParse(String token) {
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }
}
