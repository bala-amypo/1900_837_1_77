package com.example.demo.service;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface RecommendationService {

    // REQUIRED by Controller & TestNG
    List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId);

    // REQUIRED by TestNG
    List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId);
}
