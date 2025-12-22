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

        public Builder id(Long id) { r.setId(id); return this; }
        public Builder studentProfileId(Long s) { r.setStudentProfileId(s); return this; }
        public Builder skillId(Long s) { r.setSkillId(s); return this; }
        public Builder gapScore(double g) { r.setGapScore(g); return this; }

        public SkillGapRecommendation build() { return r; }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentProfileId() { return studentProfileId; }
    public void setStudentProfileId(Long studentProfileId) { this.studentProfileId = studentProfileId; }

    public Long getSkillId() { return skillId; }
    public void setSkillId(Long skillId) { this.skillId = skillId; }

    public double getGapScore() { return gapScore; }
    public void setGapScore(double gapScore) { this.gapScore = gapScore; }
}
