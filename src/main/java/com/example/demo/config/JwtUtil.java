package com.example.demo.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    // secret should come from application.properties in real app
    private final Key signingKey = Keys.hmacShaKeyFor("replace_this_with_a_very_long_secret_key_which_is_at_least_256_bits".getBytes());
    private final long expirationMs = 1000L * 60 * 60 * 24; // 1 day

    // Validate and return Claims (used by JwtAuthenticationFilter)
    public Claims validateAndParse(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Overload: generate token using username + role strings (tests expect this)
    public String generateToken(String username, String role) {
        return createToken(Map.of("role", role), username);
    }

    // Overload: generate token for a User-like object (safe to have both)
    public String generateTokenForUser(String username, String role) {
        return createToken(Map.of("role", role), username);
    }

    private String createToken(Map<String, Object> extraClaims, String subject) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(subject)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + expirationMs))
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = validateAndParse(token);
        return claimsResolver.apply(claims);
    }

    public String getSubject(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isExpired(String token) {
        Date exp = getClaim(token, Claims::getExpiration);
        return exp.before(new Date());
    }
}
