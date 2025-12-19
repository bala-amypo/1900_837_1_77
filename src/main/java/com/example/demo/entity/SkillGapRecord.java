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

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setCurrentScore(double currentScore) {
        this.currentScore = currentScore;
    }

    public void setTargetScore(double targetScore) {
        this.targetScore = targetScore;
    }

    public void setGapScore(double gapScore) {
        this.gapScore = gapScore;
    }
}
