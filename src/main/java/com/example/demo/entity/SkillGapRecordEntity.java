package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "skill_gap_records")
@IdClass(SkillGapKey.class)
public class SkillGapRecordEntity {

    @Id
    @ManyToOne
    private StudentProfileEntity studentProfile;

    @Id
    @ManyToOne
    private SkillEntity skill;

    private Double currentScore;
    private Double targetScore;
    private Double gapScore;

    private Timestamp calculatedAt = new Timestamp(System.currentTimeMillis());

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

    public Double getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Double currentScore) {
        this.currentScore = currentScore;
    }

    public Double getTargetScore() {
        return targetScore;
    }

    public void setTargetScore(Double targetScore) {
        this.targetScore = targetScore;
    }

    public Double getGapScore() {
        return gapScore;
    }

    public void setGapScore(Double gapScore) {
        this.gapScore = gapScore;
    }

    public Timestamp getCalculatedAt() {
        return calculatedAt;
    }
}
