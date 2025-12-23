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

    /* ==== Builder ==== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SkillGapRecommendation r = new SkillGapRecommendation();

        public Builder id(Long id) { r.id = id; return this; }
        public Builder studentProfileId(Long s) { r.studentProfileId = s; return this; }
        public Builder skillId(Long s) { r.skillId = s; return this; }
        public Builder gapScore(double g) { r.gapScore = g; return this; }

        public SkillGapRecommendation build() { return r; }
    }

    /* ==== GET / SET ==== */
    public Long getId() { return id; }
    public Long getStudentProfileId() { return studentProfileId; }
    public Long getSkillId() { return skillId; }
    public double getGapScore() { return gapScore; }

    public void setId(Long id) { this.id = id; }
    public void setStudentProfileId(Long id2) { this.studentProfileId = id2; }
    public void setSkillId(Long skillId) { this.skillId = skillId; }
    public void setGapScore(double gapScore) { this.gapScore = gapScore; }
}
