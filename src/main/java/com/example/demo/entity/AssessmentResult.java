package com.example.demo.entity;

import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    private Long id;
    private String enrollmentId;
    private String name;
    private String cohort;
    private Instant lastUpdated;

    public void preUpdate() {
        this.lastUpdated = Instant.now();
    }
}
