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
    private double score;
    private Instant attemptedAt;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;
}
