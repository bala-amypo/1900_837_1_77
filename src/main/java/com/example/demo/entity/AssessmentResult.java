package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assessmentId;

    @ManyToOne
    private StudentProfile student;

    @ManyToOne
    private Skill skill;

    private double score;
    private Instant attemptedAt;

    public double getScore() {
        return score;
    }

    public Instant getAttemptedAt() {
        return attemptedAt;
    }
}
