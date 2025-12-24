package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);

    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentId);
}
