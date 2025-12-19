package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String email;

    private String password;

    private String role;

    private Timestamp createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        if (this.role == null) {
            this.role = "STUDENT";
        }
    }

    // getters & setters
}
