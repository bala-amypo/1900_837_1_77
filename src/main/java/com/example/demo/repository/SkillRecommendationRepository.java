package com.example.demo.repository;

import com.example.demo.entity.SkillRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRecommendationRepository extends JpaRepository<SkillRecommendation, Long> {

    List<SkillRecommendation> findByStudentProfileId(Long studentProfileId);
}
