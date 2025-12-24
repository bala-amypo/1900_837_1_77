package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    // Used in multiple tests
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentId);

    // ⭐ REQUIRED BY TEST CASE t038 — MUST BE EXACT NAME
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);
}
