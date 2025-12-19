package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Skill skill;

    private double gapScore;
    private String priority;
    private String recommendedAction;
    private String generatedBy;

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setGapScore(double gapScore) {
        this.gapScore = gapScore;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }
}
