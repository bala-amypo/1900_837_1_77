package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentId);

    @Query("SELECT r FROM SkillGapRecommendation r WHERE r.studentProfile.id = ?1 ORDER BY r.generatedAt DESC")
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);
}
