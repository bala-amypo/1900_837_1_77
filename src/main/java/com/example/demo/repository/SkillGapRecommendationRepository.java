package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    // TEST t038 expects this EXACT method name
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentId);

    // TEST also calls this method name
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);
}
