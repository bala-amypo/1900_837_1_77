package com.example.demo.repository;

import com.example.demo.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    // REQUIRED BY TEST t006 FOR DUPLICATE CHECK
    Optional<Skill> findByCode(String code);

    // REQUIRED BY ACTIVE SKILL TESTS
    List<Skill> findByActiveTrue();
}
