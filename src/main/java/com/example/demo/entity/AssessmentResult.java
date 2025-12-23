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

    /* ===== Builder ===== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final AssessmentResult r = new AssessmentResult();

        public Builder id(Long id) { r.id = id; return this; }
        public Builder assessmentId(String a) { r.assessmentId = a; return this; }
        public Builder studentProfileId(Long s) { r.studentProfileId = s; return this; }
        public Builder skillId(Long s) { r.skillId = s; return this; }
        public Builder score(double s) { r.score = s; return this; }

        public AssessmentResult build() { return r; }
    }

    /* ===== GET / SET ===== */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }

    public Long getStudentProfileId() { return studentProfileId; }
    public void setStudentProfileId(Long spid) { this.studentProfileId = spid; }

    public Long getSkillId() { return skillId; }
    public void setSkillId(Long skillId) { this.skillId = skillId; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}
