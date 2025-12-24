package com.example.demo.repository;

import com.example.demo.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findByCode(String code);

    // ⭐ Needed for test case t006 (case-insensitive duplicate code check)
    Optional<Skill> findByCodeIgnoreCase(String code);

    // ⭐ Used by getActiveSkills()
    java.util.List<Skill> findByActiveTrue();
}
