package com.example.demo.entity;

import lombok.*;
import java.time.Instant;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    private Long id;
    private String enrollmentId;
    private String grade;
    private Instant lastUpdatedAt;

    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }
}
