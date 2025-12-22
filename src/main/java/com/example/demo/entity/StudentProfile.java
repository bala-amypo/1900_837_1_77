package com.example.demo.entity;

import lombok.*;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    private Long id;
    private User user;
    private String enrollmentId;
    private String grade;
    private boolean active = true;
    private Instant lastUpdatedAt = Instant.now();

    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }
}
