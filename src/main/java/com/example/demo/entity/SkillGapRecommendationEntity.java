package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "skill_gap_recommendations")
@IdClass(SkillGapKey.class)
public class SkillGapRecommendationEntity {

    @Id
    @ManyToOne
    private StudentProfileEntity studentProfile;

    @Id
    @ManyToOne
    private SkillEntity skill;

    private String recommendedAction;
    private String priority;
    private Double gapScore;
    private String generatedBy;

    private Timestamp generatedAt = new Timestamp(System.currentTimeMillis());

    // ===== Getters & Setters =====

    public StudentProfileEntity getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfileEntity studentProfile) {
        this.studentProfile = studentProfile;
    }

    public SkillEntity getSkill() {
        return skill;
    }

    public void setSkill(SkillEntity skill) {
        this.skill = skill;
    }

    public String getRecommendedAction() {
        return recommendedAction;
    }

    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Double getGapScore() {
        return gapScore;
    }

    public void setGapScore(Double gapScore) {
        this.gapScore = gapScore;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Timestamp getGeneratedAt() {
        return generatedAt;
    }
}
