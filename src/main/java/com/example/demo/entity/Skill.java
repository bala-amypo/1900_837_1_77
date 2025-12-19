package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double minCompetencyScore;

    // ===== GETTERS & SETTERS =====
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMinCompetencyScore() {
        return minCompetencyScore;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinCompetencyScore(double minCompetencyScore) {
        this.minCompetencyScore = minCompetencyScore;
    }
}
