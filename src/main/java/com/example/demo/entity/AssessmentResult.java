package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assessmentId;
    private Long studentProfileId;
    private Long skillId;
    private double score;

    public AssessmentResult() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final AssessmentResult r = new AssessmentResult();

        public Builder id(Long id) { r.id = id; return this; }
        public Builder assessmentId(String a) { r.assessmentId = a; return this; }
        public Builder studentProfileId(Long s) { r.studentProfileId = s; return this; }
        public Builder skillId(Long s) { r.skillId = s; return this; }
        public Builder score(double sc) { r.score = sc; return this; }

        public AssessmentResult build() { return r; }
    }

    // Getters / Setters
    public Long getId() { return id; }
    public String getAssessmentId() { return assessmentId; }
    public Long getStudentProfileId() { return studentProfileId; }
    public Long getSkillId() { return skillId; }
    public double getScore() { return score; }

    public void setId(Long id) { this.id = id; }
    public void setAssessmentId(String a) { this.assessmentId = a; }
    public void setStudentProfileId(Long s) { this.studentProfileId = s; }
    public void setSkillId(Long s) { this.skillId = s; }
    public void setScore(double score) { this.score = score; }
}
