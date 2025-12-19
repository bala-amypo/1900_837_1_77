package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills", uniqueConstraints = {
        @UniqueConstraint(columnNames = "skillName")
})
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String skillName;

    @Column(nullable = false)
    private String category;

    private String description;

    @Column(nullable = false)
    private Double minCompetencyScore;

    @Column(nullable = false)
    private Boolean active = true;

    public Skill() {}

    /* Getters & Setters */
    public Long getId() { return id; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getMinCompetencyScore() { return minCompetencyScore; }
    public void setMinCompetencyScore(Double minCompetencyScore) {
        if (minCompetencyScore < 0 || minCompetencyScore > 100) {
            throw new IllegalArgumentException("minCompetencyScore must be between 0 and 100");
        }
        this.minCompetencyScore = minCompetencyScore;
    }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
