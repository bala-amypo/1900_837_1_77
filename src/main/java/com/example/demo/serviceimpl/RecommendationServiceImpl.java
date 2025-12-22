package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class RecommendationServiceImpl {

    private final SkillGapRecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(SkillGapRecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public SkillGapRecommendation create(Long studentId, Long skillId, String text) {
        return recommendationRepository.save(
                SkillGapRecommendation.builder()
                        .studentProfileId(studentId)
                        .skillId(skillId)
                        .recommendation(text)
                        .generatedAt(Instant.now())
                        .build()
        );
    }

    public List<SkillGapRecommendation> getForStudent(Long studentId) {
        return recommendationRepository.findByStudentOrdered(studentId);
    }
}
