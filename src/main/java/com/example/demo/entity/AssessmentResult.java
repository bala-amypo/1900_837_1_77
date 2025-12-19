package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "assessment_results")
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    @ManyToOne(optional = false)
    private Skill skill;

    @Column(nullable = false)
    private String assessmentId;

    @Column(nullable = false)
    private Double scoreObtained;

    @Column(nullable = false)
    private Double maxScore = 100.0;

    @Column(nullable = false)
    private Instant assessedAt;

    @PrePersist
    public void onCreate() {
        assessedAt = Instant.now();
        if (maxScore == null) {
            maxScore = 100.0;
        }
    }

    public AssessmentResult() {}

    /* Getters & Setters */
    public Long getId() { return id; }

    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }

    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }

    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }

    public Double getScoreObtained() { return scoreObtained; }
    public void setScoreObtained(Double scoreObtained) { this.scoreObtained = scoreObtained; }

    public Double getMaxScore() { return maxScore; }
    public void setMaxScore(Double maxScore) { this.maxScore = maxScore; }

    public Instant getAssessedAt() { return assessedAt; }
}
