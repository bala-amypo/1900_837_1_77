package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    @ManyToOne
    private Skill skill;

    private Double gapScore;
    private String generatedBy;
    private Instant generatedAt = Instant.now();

    public Long getId(){ return id; }
    public Long getStudentId(){ return studentId; }
    public Skill getSkill(){ return skill; }
    public Double getGapScore(){ return gapScore; }
    public String getGeneratedBy(){ return generatedBy; }
    public Instant getGeneratedAt(){ return generatedAt; }

    public void setId(Long id){ this.id = id; }
    public void setStudentId(Long s){ this.studentId = s; }
    public void setSkill(Skill skill){ this.skill = skill; }
    public void setGapScore(Double g){ this.gapScore = g; }
    public void setGeneratedBy(String g){ this.generatedBy = g; }

    // ---------- builder (TEST REQUIRED) ----------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SkillGapRecommendation r = new SkillGapRecommendation();
        public Builder id(Long id){ r.setId(id); return this; }
        public Builder studentId(Long s){ r.setStudentId(s); return this; }
        public Builder skill(Skill s){ r.setSkill(s); return this; }
        public Builder gapScore(Double g){ r.setGapScore(g); return this; }
        public Builder generatedBy(String g){ r.setGeneratedBy(g); return this; }
        public SkillGapRecommendation build(){ return r; }
    }
}
