package com.example.demo.repository;

import com.example.demo.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    // OPTIONAL (used in validations)
    Optional<Skill> findBySkillName(String skillName);

    // REQUIRED in gap calculation
    List<Skill> findByActiveTrue();
}
