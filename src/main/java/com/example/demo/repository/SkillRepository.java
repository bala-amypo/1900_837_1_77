package com.example.demo.repository;

import com.example.demo.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository
        extends JpaRepository<SkillEntity, String> {

    Optional<SkillEntity> findBySkillName(String skillName);

    List<SkillEntity> findByActiveTrue();
}
