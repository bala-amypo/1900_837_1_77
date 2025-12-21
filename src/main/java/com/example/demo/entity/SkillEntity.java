package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class SkillEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String skillName;

    private String category;

    private String description;

    private Double minCompetencyScore;

    private Boolean active = true;

    // ===== Getters & Setters =====

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMinCompetencyScore() {
        return minCompetencyScore;
    }

    public void setMinCompetencyScore(Double minCompetencyScore) {
        this.minCompetencyScore = minCompetencyScore;
    }

    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
}
