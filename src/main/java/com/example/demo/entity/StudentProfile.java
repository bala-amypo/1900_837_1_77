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
    private Instant lastUpdatedAt;

    public StudentProfile() {}

    /* ---------- BUILDER (REQUIRED BY TEST) ---------- */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final StudentProfile p = new StudentProfile();

        public Builder userId(Long userId) {
            p.userId = userId;
            return this;
        }

        public Builder enrollmentId(String enrollmentId) {
            p.enrollmentId = enrollmentId;
            return this;
        }

        public Builder lastUpdatedAt(Instant time) {
            p.lastUpdatedAt = time;
            return this;
        }

        public StudentProfile build() {
            return p;
        }
    }

    /* ---------- GETTERS ---------- */
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getEnrollmentId() { return enrollmentId; }
    public Instant getLastUpdatedAt() { return lastUpdatedAt; }
}
