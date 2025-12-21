package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String fullName;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // add any convenience getters if tests expect getBody() etc (they shouldn't be here)
}
