package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String role;
    private Instant createdAt;
}
