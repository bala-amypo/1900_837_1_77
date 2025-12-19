package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "skillName")
})
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private String category;
    private String description;
    private Double minCompetencyScore;
    private Boolean active = true;

    // getters & setters
}
