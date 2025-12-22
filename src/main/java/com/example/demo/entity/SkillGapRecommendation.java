package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String recommendation;
    private Instant generatedAt;

    public SkillGapRecommendation() {}

    // 🔴 REQUIRED BY TESTCASES
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SkillGapRecommendation obj = new SkillGapRecommendation();

        public Builder studentId(Long studentId) {
            obj.studentId = studentId;
            return this;
        }

        public Builder recommendation(String recommendation) {
            obj.recommendation = recommendation;
            return this;
        }

        public Builder generatedAt(Instant generatedAt) {
            obj.generatedAt = generatedAt;
            return this;
        }

        public SkillGapRecommendation build() {
            return obj;
        }
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public Instant getGeneratedAt() {
        return generatedAt;
    }
}
