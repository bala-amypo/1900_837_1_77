package com.example.demo.entity;

import java.time.Instant;

public class SkillGapRecommendation {

    private Long id;
    private Skill skill;
    private Double gapScore;
    private String generatedBy;
    private Instant generatedAt = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }

    public Double getGapScore() { return gapScore; }
    public void setGapScore(Double gapScore) { this.gapScore = gapScore; }

    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }

    public Instant getGeneratedAt() { return generatedAt; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final SkillGapRecommendation r = new SkillGapRecommendation();
        public Builder id(Long id){ r.setId(id); return this; }
        public Builder skill(Skill s){ r.setSkill(s); return this; }
        public Builder gapScore(Double g){ r.setGapScore(g); return this; }
        public Builder generatedBy(String g){ r.setGeneratedBy(g); return this; }
        public SkillGapRecommendation build(){ return r; }
    }
}
