package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SkillGapScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;

    private Integer gapScore;

    // 🔹 Getters & Setters
    public Long getId() {
        return id;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Integer getGapScore() {
        return gapScore;
    }

    public void setGapScore(Integer gapScore) {
        this.gapScore = gapScore;
    }
}
