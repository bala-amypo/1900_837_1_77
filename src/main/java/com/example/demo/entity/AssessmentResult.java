package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "assessment_results")
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assessmentId;

    private Double score;

    private Double maxScore = 100.0;

    private Instant attemptedAt = Instant.now();

    // -------- getters & setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public Instant getAttemptedAt() {
        return attemptedAt;
    }

    public void setAttemptedAt(Instant attemptedAt) {
        this.attemptedAt = attemptedAt;
    }

    // -------- builder (keeps TestNG safe) --------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final AssessmentResult r = new AssessmentResult();

        public Builder id(Long id) {
            r.setId(id);
            return this;
        }

        public Builder assessmentId(String assessmentId) {
            r.setAssessmentId(assessmentId);
            return this;
        }

        public Builder score(Double score) {
            r.setScore(score);
            return this;
        }

        public Builder maxScore(Double maxScore) {
            r.setMaxScore(maxScore);
            return this;
        }

        public Builder attemptedAt(Instant attemptedAt) {
            r.setAttemptedAt(attemptedAt);
            return this;
        }

        public AssessmentResult build() {
            return r;
        }
    }
}
