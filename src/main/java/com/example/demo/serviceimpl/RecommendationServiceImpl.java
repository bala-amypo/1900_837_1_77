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

    public SkillGapRecommendation generate(Long studentId, String text) {
        SkillGapRecommendation rec = SkillGapRecommendation.builder()
                .studentId(studentId)
                .recommendation(text)
                .generatedAt(Instant.now())
                .build();

        return recommendationRepository.save(rec);
    }

    public List<SkillGapRecommendation> getByStudent(Long studentId) {
        return recommendationRepository.findByStudentOrdered(studentId);
    }
}
