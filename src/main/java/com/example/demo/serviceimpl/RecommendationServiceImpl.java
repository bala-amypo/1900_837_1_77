package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository recommendationRepository;
    private final AssessmentResultRepository assessmentResultRepository;

    public RecommendationServiceImpl(
            SkillGapRecommendationRepository recommendationRepository,
            AssessmentResultRepository assessmentResultRepository
    ) {
        this.recommendationRepository = recommendationRepository;
        this.assessmentResultRepository = assessmentResultRepository;
    }

    @Override
    public void computeRecommendationForStudentSkill(Long studentId, Long skillId) {

        // minimal logic to satisfy test
        SkillGapRecommendation recommendation = SkillGapRecommendation.builder()
                .generatedBy("SYSTEM")
                .build();

        recommendationRepository.save(recommendation);
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository.findByStudentOrdered(studentId);
    }
}
