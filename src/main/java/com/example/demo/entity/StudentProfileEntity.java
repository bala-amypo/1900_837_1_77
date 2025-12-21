package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "student_profiles")
public class StudentProfileEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String enrollmentId;

    @OneToOne
    private UserEntity user;

    private String cohort;

    private Integer yearLevel;

    private Boolean active = true;

    private Timestamp lastUpdatedAt;

    @PreUpdate
    public void onUpdate() {
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ===== Getters & Setters =====

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    public Integer getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(Integer yearLevel) {
        this.yearLevel = yearLevel;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }
}
