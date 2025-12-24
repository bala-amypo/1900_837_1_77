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
public class AssessmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long skillId;
    private Double score;

    private Instant attemptedAt;

    @PrePersist
    public void setAttemptTime() {
        this.attemptedAt = Instant.now();
    }
}
