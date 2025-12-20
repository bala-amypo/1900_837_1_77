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

    @Column(nullable = false, updatable = false)
    private Instant generatedAt = Instant.now();

    // getters & setters
    public Long getId() { return id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public String getRecommendedAction() { return recommendedAction; }
    public void setRecommendedAction(String recommendedAction) { this.recommendedAction = recommendedAction; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public Double getGapScore() { return gapScore; }
    public void setGapScore(Double gapScore) { this.gapScore = gapScore; }
    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
}
