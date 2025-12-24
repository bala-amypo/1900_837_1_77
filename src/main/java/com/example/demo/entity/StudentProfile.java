package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

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

    // ⭐ REQUIRED BY TEST CASES
    private String grade;

    // Other fields if you have them...
}
