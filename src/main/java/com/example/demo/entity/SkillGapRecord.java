package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "skill_gap_records")
public class SkillGapRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    @ManyToOne(optional = false)
    private Skill skill;

    @Column(nullable = false)
    private Double currentScore;

    @Column(nullable = false)
    private Double targetScore;

    @Column(nullable = false)
    private Double gapScore;

    @Column(nullable = false)
    private Instant calculatedAt;

    @PrePersist
    public void onCreate() {
        calculatedAt = Instant.now();
    }

    public SkillGapRecord() {}

    /* Getters & Setters */
}
