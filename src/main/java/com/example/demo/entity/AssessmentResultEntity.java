package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "assessment_results")
@IdClass(AssessmentResultKey.class)
public class AssessmentResultEntity {

    @Id
    @ManyToOne
    private StudentProfileEntity studentProfile;

    @Id
    @ManyToOne
    private SkillEntity skill;

    private Double scoreObtained;

    private Double maxScore = 100.0;

    private Timestamp assessedAt = new Timestamp(System.currentTimeMillis());

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

    public Double getScoreObtained() {
        return scoreObtained;
    }

    public void setScoreObtained(Double scoreObtained) {
        this.scoreObtained = scoreObtained;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public Timestamp getAssessedAt() {
        return assessedAt;
    }
}
