package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(unique = true)
    private String enrollmentId;

    private String cohort;

    private Integer yearLevel;

    private Boolean active = true;

    // getters & setters
}
