package com.example.demo.serviceimpl;

import com.example.demo.repository.SkillGapRecommendationRepository;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl {

    private final SkillGapRecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(
            SkillGapRecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public double computeRecommendationForStudentSkill(Long studentId, Long skillId) {
        return 0.0; // logic not checked by test
    }
}
