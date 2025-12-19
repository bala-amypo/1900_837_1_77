package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "skill_gap_recommendations")
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    @ManyToOne(optional = false)
    private Skill skill;

    @Column(nullable = false)
    private String recommendedAction;

    @Column(nullable = false)
    private String priority;

    @Column(nullable = false)
    private Double gapScore;

    @Column(nullable = false)
    private String generatedBy;

    @Column(nullable = false)
    private Instant generatedAt;

    @PrePersist
    public void onCreate() {
        generatedAt = Instant.now();
    }

    public SkillGapRecommendation() {}
}
