package com.example.demo.config;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import java.io.IOException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class JwtAuthenticationFilter implements Filter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest http = (HttpServletRequest) request;
        String authHeader = http.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            try {
                Jws<Claims> parsed = jwtUtil.validateAndParse(token);
                String email = parsed.getBody().get("email", String.class);

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(email, null, null);
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(http));

                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception ex) {
                // Invalid token → ignore, user stays unauthenticated
            }
        }

        chain.doFilter(request, response);
    }
}
