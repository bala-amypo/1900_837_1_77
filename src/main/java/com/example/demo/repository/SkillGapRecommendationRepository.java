package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillGapRecommendationRepository
        extends JpaRepository<SkillGapRecommendation, Long> {

    // 🔥 REQUIRED BY TEST
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);

    // existing / service-friendly method
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(
            Long studentProfileId);
}
