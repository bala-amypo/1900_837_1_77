package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String enrollmentId;
    private String cohort;
    private Instant lastUpdatedAt;

    public StudentProfile() {}

    public StudentProfile(Long userId, String enrollmentId, String cohort) {
        this.userId = userId;
        this.enrollmentId = enrollmentId;
        this.cohort = cohort;
        this.lastUpdatedAt = Instant.now();
    }

    // ===== Getters & Setters =====

    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }

    public String getCohort() { return cohort; }
    public void setCohort(String cohort) { this.cohort = cohort; }

    public Instant getLastUpdatedAt() { return lastUpdatedAt; }
    public void setLastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }
}
