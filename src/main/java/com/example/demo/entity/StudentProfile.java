package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Getter
@Setter
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
    private String grade;

    private Instant createdAt;
    private Instant lastUpdatedAt;

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.lastUpdatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }
}
