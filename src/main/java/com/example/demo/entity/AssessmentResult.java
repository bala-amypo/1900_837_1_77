package com.example.demo.entity;

import java.time.Instant;

public class AssessmentResult {

    private Long id;
    private String assessmentId;
    private Double score;
    private Double maxScore = 100.0;
    private Instant attemptedAt = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public Double getMaxScore() { return maxScore; }
    public void setMaxScore(Double maxScore) { this.maxScore = maxScore; }

    public Instant getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(Instant attemptedAt) { this.attemptedAt = attemptedAt; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final AssessmentResult r = new AssessmentResult();
        public Builder id(Long id){ r.setId(id); return this; }
        public Builder assessmentId(String a){ r.setAssessmentId(a); return this; }
        public Builder score(Double s){ r.setScore(s); return this; }
        public Builder maxScore(Double m){ r.setMaxScore(m); return this; }
        public Builder attemptedAt(Instant i){ r.setAttemptedAt(i); return this; }
        public AssessmentResult build(){ return r; }
    }
}
