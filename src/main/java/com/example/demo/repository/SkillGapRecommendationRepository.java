package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface SkillGapRecommendationRepository {

    SkillGapRecommendation save(SkillGapRecommendation recommendation);

    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);
}
