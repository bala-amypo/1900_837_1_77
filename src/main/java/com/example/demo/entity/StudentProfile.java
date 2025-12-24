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
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(unique = true, nullable = false)
    private String enrollmentId;

    private String cohort;

    private Integer yearLevel;

    private boolean active = true;

    private Instant lastUpdatedAt = Instant.now();

    @PreUpdate
    public void preUpdate() {
        lastUpdatedAt = Instant.now();
    }
}
