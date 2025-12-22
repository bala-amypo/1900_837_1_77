package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillGapRecommendationRepository
        extends JpaRepository<SkillGapRecommendation, Long> {

    // 🔴 REQUIRED BY TESTCASE
    List<SkillGapRecommendation> findByStudentIdOrderByGeneratedAtDesc(Long studentId);

    // alias expected by test
    default List<SkillGapRecommendation> findByStudentOrdered(Long studentId) {
        return findByStudentIdOrderByGeneratedAtDesc(studentId);
    }
}
