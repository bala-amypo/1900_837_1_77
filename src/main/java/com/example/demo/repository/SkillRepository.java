package com.example.demo.repository;

import com.example.demo.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;        // ⭐ REQUIRED IMPORT
import java.util.Optional;    // ⭐ REQUIRED IMPORT

public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findByCodeIgnoreCase(String code);

    List<Skill> findByActiveTrue();
}
