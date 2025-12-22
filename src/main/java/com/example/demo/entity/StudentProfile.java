package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String enrollmentId;
    private String grade;

    private Instant lastUpdatedAt;

    // ---------- lifecycle ----------
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }

    // ---------- getters ----------
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getEnrollmentId() { return enrollmentId; }
    public String getGrade() { return grade; }
    public Instant getLastUpdatedAt() { return lastUpdatedAt; }

    // ---------- setters ----------
    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setLastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }

    // ---------- builder (TEST REQUIRED) ----------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final StudentProfile p = new StudentProfile();
        public Builder id(Long id){ p.setId(id); return this; }
        public Builder userId(Long u){ p.setUserId(u); return this; }
        public Builder enrollmentId(String e){ p.setEnrollmentId(e); return this; }
        public Builder grade(String g){ p.setGrade(g); return this; }
        public Builder lastUpdatedAt(Instant t){ p.setLastUpdatedAt(t); return this; }
        public StudentProfile build(){ return p; }
    }
}
