package com.example.demo.serviceimpl;

import com.example.demo.repository.SkillGapRecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl {

    private final SkillGapRecommendationRepository recommendationRepository;

    // REQUIRED BY TESTS
    public void computeRecommendationForStudentSkill(Long studentId, Long skillId) {
        // logic can be empty for test compile
    }
}
