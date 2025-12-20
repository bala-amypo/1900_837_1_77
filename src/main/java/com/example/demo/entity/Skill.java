package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // 🔹 REQUIRED: No-arg constructor
    public Skill() {
    }

    // 🔹 Optional constructor
    public Skill(String name) {
        this.name = name;
    }

    // 🔹 GETTERS & SETTERS (THIS FIXES YOUR ERROR)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {   // ✅ REQUIRED
        return name;
    }

    public void setName(String name) {   // ✅ REQUIRED
        this.name = name;
    }
}
