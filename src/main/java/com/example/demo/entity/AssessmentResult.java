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

    private Double score;

    private Double maxScore = 100.0;

    private Instant attemptedAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    // ✅ THIS FIELD FIXES YOUR ERROR
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
