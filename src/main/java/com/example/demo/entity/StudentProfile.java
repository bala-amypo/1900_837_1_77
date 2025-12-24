package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enrollmentId;

    private Long userId;

    private String name;

    private String department;

    private String cohort;

    private String grade;    // ⭐ required by test

    // ⭐ REQUIRED BY TEST CASES
    private Instant createdAt;
    private Instant lastUpdatedAt;

    // JPA lifecycle hooks
    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
        this.lastUpdatedAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }
}
