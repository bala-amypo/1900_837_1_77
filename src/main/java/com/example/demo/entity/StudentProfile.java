package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enrollmentId;
    private Long userId;
    private String name;
    private String department;
    private String cohort;
    private String grade;

    private Instant createdAt;
    private Instant lastUpdatedAt;

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        createdAt = now;
        lastUpdatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdatedAt = Instant.now(); // test expects this
    }

    @PrePersist
public void onCreate() {
    this.lastUpdated = Instant.now();
}

@PreUpdate
public void onUpdate() {
    this.lastUpdated = Instant.now();
}

}
