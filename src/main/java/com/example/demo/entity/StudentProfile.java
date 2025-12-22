package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enrollmentId;
    private String name;
    private String cohort;
    private Instant lastUpdated;

    public StudentProfile() {}

    /* ===== BUILDER SUPPORT (REQUIRED BY TESTCASE) ===== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final StudentProfile p = new StudentProfile();

        public Builder id(Long id) {
            p.setId(id);
            return this;
        }

        public Builder enrollmentId(String enrollmentId) {
            p.setEnrollmentId(enrollmentId);
            return this;
        }

        public Builder name(String name) {
            p.setName(name);
            return this;
        }

        public Builder cohort(String cohort) {
            p.setCohort(cohort);
            return this;
        }

        public Builder lastUpdated(Instant t) {
            p.setLastUpdated(t);
            return this;
        }

        public StudentProfile build() {
            return p;
        }
    }

    /* ===== GETTERS & SETTERS ===== */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCohort() { return cohort; }
    public void setCohort(String cohort) { this.cohort = cohort; }

    public Instant getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Instant lastUpdated) { this.lastUpdated = lastUpdated; }
}
