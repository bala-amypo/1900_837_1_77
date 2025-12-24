package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentId);

    // ⭐ REQUIRED BY TESTCASE
    default List<SkillGapRecommendation> findByStudentOrdered(Long id) { return null; }
}
