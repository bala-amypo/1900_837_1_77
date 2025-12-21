package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SkillGapRecommendationEntity;

public interface SkillGapRecommendationRepository
        extends JpaRepository<SkillGapRecommendationEntity, Long> {

    List<SkillGapRecommendationEntity>
        findByStudentProfileIdOrderByGeneratedAtDesc(Long studentProfileId);
}
