package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;

    private Double scoreObtained;
    private Double maxScore;

    private Instant assessedAt = Instant.now();

    // getters & setters
}
