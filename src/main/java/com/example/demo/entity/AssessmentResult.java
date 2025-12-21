package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssessmentResult {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assessmentId;
    private double maxScore;
    private double score;
    private String grade;
    private Instant attemptedAt;

    @ManyToOne private StudentProfile studentProfile;
    // add fields/tests expect
}
