package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;

    private Double scoreObtained;
    private Double maxScore = 100.0;

    private Timestamp assessedAt;

    @PrePersist
    public void onCreate() {
        this.assessedAt = new Timestamp(System.currentTimeMillis());
    }

    public AssessmentResult() {}

    // getters and setters
}
