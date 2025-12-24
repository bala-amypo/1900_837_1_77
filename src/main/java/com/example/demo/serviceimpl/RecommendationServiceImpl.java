package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    // ⭐ Correct method required by test t038
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentId);
}
