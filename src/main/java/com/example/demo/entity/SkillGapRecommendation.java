package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentProfileId;
    private Long skillId;
    private double gapScore;

    public SkillGapRecommendation() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SkillGapRecommendation r = new SkillGapRecommendation();

        public Builder id(Long id) { r.id = id; return this; }
        public Builder studentProfileId(Long v) { r.studentProfileId = v; return this; }
        public Builder skillId(Long v) { r.skillId = v; return this; }
        public Builder gapScore(double v) { r.gapScore = v; return this; }

        public SkillGapRecommendation build() { return r; }
    }

    // Getters & setters
    public Long getId() { return id; }
    public Long getStudentProfileId() { return studentProfileId; }
    public Long getSkillId() { return skillId; }
    public double getGapScore() { return gapScore; }

    public void setId(Long id) { this.id = id; }
    public void setStudentProfileId(Long v) { this.studentProfileId = v; }
    public void setSkillId(Long skillId) { this.skillId = skillId; }
    public void setGapScore(double gapScore) { this.gapScore = gapScore; }
}
