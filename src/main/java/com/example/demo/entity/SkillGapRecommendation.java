package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentProfileId;
    private Long skillId;
    private String recommendation;
    private Instant createdAt;

    public SkillGapRecommendation() {}

    private SkillGapRecommendation(Builder builder) {
        this.studentProfileId = builder.studentProfileId;
        this.skillId = builder.skillId;
        this.recommendation = builder.recommendation;
        this.createdAt = builder.createdAt;
    }

    // ===== BUILDER (REQUIRED FOR TEST CASES) =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long studentProfileId;
        private Long skillId;
        private String recommendation;
        private Instant createdAt = Instant.now();

        public Builder studentProfileId(Long studentProfileId) {
            this.studentProfileId = studentProfileId;
            return this;
        }

        public Builder skillId(Long skillId) {
            this.skillId = skillId;
            return this;
        }

        public Builder recommendation(String recommendation) {
            this.recommendation = recommendation;
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public SkillGapRecommendation build() {
            return new SkillGapRecommendation(this);
        }
    }

    // ===== Getters =====
    public Long getId() { return id; }
    public Long getStudentProfileId() { return studentProfileId; }
    public Long getSkillId() { return skillId; }
    public String getRecommendation() { return recommendation; }
    public Instant getCreatedAt() { return createdAt; }
}
