package com.example.demo.dto;

import com.example.demo.entity.Role;   // ✅ FIX 2
import lombok.Data;                    // ✅ FIX 1

@Data
public class RegisterRequest {

    private String email;
    private String password;
    private Role role;
}
