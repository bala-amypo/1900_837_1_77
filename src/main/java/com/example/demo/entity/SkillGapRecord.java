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

    @Column(nullable = false, updatable = false)
    private Instant calculatedAt = Instant.now();

    // getters & setters
    public Long getId() { return id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public Double getCurrentScore() { return currentScore; }
    public void setCurrentScore(Double currentScore) { this.currentScore = currentScore; }
    public Double getTargetScore() { return targetScore; }
    public void setTargetScore(Double targetScore) { this.targetScore = targetScore; }
    public Double getGapScore() { return gapScore; }
    public void setGapScore(Double gapScore) { this.gapScore = gapScore; }
}
