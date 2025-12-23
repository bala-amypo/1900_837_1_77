package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enrollmentId;
    private String name;
    private String cohort;

    public StudentProfile() {}

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final StudentProfile p = new StudentProfile();

        public Builder id(Long id) { p.id = id; return this; }
        public Builder enrollmentId(String v) { p.enrollmentId = v; return this; }
        public Builder name(String v) { p.name = v; return this; }
        public Builder cohort(String v) { p.cohort = v; return this; }

        public StudentProfile build() { return p; }
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCohort() { return cohort; }
    public void setCohort(String cohort) { this.cohort = cohort; }
}
