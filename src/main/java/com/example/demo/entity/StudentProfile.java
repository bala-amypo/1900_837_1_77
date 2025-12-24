package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(nullable=false, unique=true)
    private String enrollmentId;

    private String cohort;

    private Integer yearLevel;

    private Boolean active = true;

    private String grade;

    // IMPORTANT: Builder must initialize the value
    @Builder.Default
    private Instant lastUpdatedAt = Instant.now();

    @PrePersist
    public void prePersist() {
        this.lastUpdatedAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }
}
