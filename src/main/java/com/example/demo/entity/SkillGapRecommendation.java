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
    private Instant generatedAt;

    // ---------- getters ----------
    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public Skill getSkill() { return skill; }
    public Double getGapScore() { return gapScore; }
    public String getGeneratedBy() { return generatedBy; }
    public Instant getGeneratedAt() { return generatedAt; }

    // ---------- setters ----------
    public void setId(Long id) { this.id = id; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public void setGapScore(Double gapScore) { this.gapScore = gapScore; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
    public void setGeneratedAt(Instant generatedAt) { this.generatedAt = generatedAt; }

    // ---------- builder (TEST REQUIRED) ----------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SkillGapRecommendation r = new SkillGapRecommendation();

        public Builder id(Long id) {
            r.setId(id);
            return this;
        }

        public Builder studentId(Long studentId) {
            r.setStudentId(studentId);
            return this;
        }

        public Builder skill(Skill skill) {
            r.setSkill(skill);
            return this;
        }

        public Builder gapScore(Double gapScore) {
            r.setGapScore(gapScore);
            return this;
        }

        public Builder generatedBy(String generatedBy) {
            r.setGeneratedBy(generatedBy);
            return this;
        }

        // 🔴 THIS WAS MISSING (TEST NEEDS IT)
        public Builder generatedAt(Instant generatedAt) {
            r.setGeneratedAt(generatedAt);
            return this;
        }

        public SkillGapRecommendation build() {
            return r;
        }
    }
}
