package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    // t038 — TEST EXPECTATION:
    // Must return latest recommendations first (descending order by generatedAt)
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentId);

    // t038 — TEST CALLS THIS EXACT METHOD:
    // findByStudentOrdered(Long studentId)
    @Query("SELECT r FROM SkillGapRecommendation r WHERE r.studentProfile.id = :studentId ORDER BY r.generatedAt DESC")
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);
}
