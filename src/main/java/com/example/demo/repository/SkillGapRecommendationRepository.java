package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    // t038 requires ordering by generatedAt DESC
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentId);

    // ⭐ REQUIRED BY TEST CASE at line 497: findByStudentOrdered(long)
    @Query("SELECT r FROM SkillGapRecommendation r WHERE r.studentProfile.id = :studentId ORDER BY r.generatedAt DESC")
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);
}
