package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillGapRecommendationRepository
        extends JpaRepository<SkillGapRecommendation, Long> {

    // ✅ FIXED: replaces findByStudentOrdered (NO PartTree parsing)
    @Query("""
        SELECT r
        FROM SkillGapRecommendation r
        WHERE r.studentProfile.id = :studentId
        ORDER BY r.generatedAt DESC
    """)
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);

    // (optional) service-friendly method
    @Query("""
        SELECT r
        FROM SkillGapRecommendation r
        WHERE r.studentProfile.id = :studentProfileId
        ORDER BY r.generatedAt DESC
    """)
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(
            Long studentProfileId);
}
