package com.example.demo.entity;

import lombok.*;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentResult {

    private Long id;
    private StudentProfile studentProfile;
    private Skill skill;
    private String assessmentId;
    private Double score;
    private Double maxScore = 100.0;
    private Instant attemptedAt = Instant.now();
}
