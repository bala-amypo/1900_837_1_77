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

    /* REQUIRED BY TEST */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SkillGapRecommendation r = new SkillGapRecommendation();

        public Builder studentId(Long id) {
            r.studentId = id;
            return this;
        }

        public Builder recommendation(String rec) {
            r.recommendation = rec;
            return this;
        }

        public Builder generatedAt(Instant time) {
            r.generatedAt = time;
            return this;
        }

        public SkillGapRecommendation build() {
            return r;
        }
    }
}
