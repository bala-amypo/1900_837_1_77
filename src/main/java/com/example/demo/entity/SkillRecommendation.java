package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class SkillRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;

    private String recommendationText;
    private String priority;
    private Double gapScore;
    private String generatedBy;

    private Timestamp generatedAt;

    @PrePersist
    public void onCreate() {
        this.generatedAt = new Timestamp(System.currentTimeMillis());
    }

    public SkillRecommendation() {}

    // getters and setters
}
