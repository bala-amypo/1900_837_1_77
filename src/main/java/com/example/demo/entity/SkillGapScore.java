package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class SkillGapScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;

    private Double currentScore;
    private Double targetScore;
    private Double gapScore;

    private Timestamp calculatedAt;

    @PrePersist
    public void onCreate() {
        this.calculatedAt = new Timestamp(System.currentTimeMillis());
    }

    public SkillGapScore() {}

    // getters and setters
}
