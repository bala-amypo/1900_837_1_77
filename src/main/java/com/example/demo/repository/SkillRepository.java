package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SkillEntity;

public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

    Optional<SkillEntity> findBySkillName(String skillName);

    List<SkillEntity> findByActiveTrue();
}
