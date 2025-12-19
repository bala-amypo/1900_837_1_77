package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "student_profiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "enrollmentId")
})
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String enrollmentId;
    private String cohort;
    private Integer yearLevel;
    private Boolean active = true;

    private Timestamp lastUpdatedAt;

    @PreUpdate
    public void onUpdate() {
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // getters & setters
}
