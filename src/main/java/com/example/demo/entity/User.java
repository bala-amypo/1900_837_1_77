package com.example.demo.entity;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public enum Role { ADMIN, INSTRUCTOR, STUDENT }

    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Role role;
}
