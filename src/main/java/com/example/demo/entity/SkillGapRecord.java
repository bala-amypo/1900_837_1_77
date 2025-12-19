package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SkillGapRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Skill skill;

    private double currentScore;
    private double targetScore;
    private double gapScore;

    public Long getId() {
        return id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public double getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(double currentScore) {
        this.currentScore = currentScore;
    }

    public double getTargetScore() {
        return targetScore;
    }

    public void setTargetScore(double targetScore) {
        this.targetScore = targetScore;
    }

    public double getGapScore() {
        return gapScore;
    }

    public void setGapScore(double gapScore) {
        this.gapScore = gapScore;
    }
}
