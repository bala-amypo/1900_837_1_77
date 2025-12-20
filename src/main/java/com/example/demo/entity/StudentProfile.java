package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Entity
@Getter
@Setter
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(nullable = false, unique = true)
    private String enrollmentId;

    private String cohort;
    private Integer yearLevel;
    private Boolean active = true;
    private Instant lastUpdatedAt = Instant.now();

    @PreUpdate
    public void updateTimestamp() {
        lastUpdatedAt = Instant.now();
    }
}
