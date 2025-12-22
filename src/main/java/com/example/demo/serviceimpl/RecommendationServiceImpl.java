package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(
            SkillGapRecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public SkillGapRecommendation generate(Long studentId) {
        SkillGapRecommendation rec =
                SkillGapRecommendation.builder()
                        .studentId(studentId)
                        .recommendation("Improve Java & SQL")
                        .generatedAt(Instant.now())
                        .build();

        return recommendationRepository.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> getByStudent(Long studentId) {
        return recommendationRepository.findByStudentOrdered(studentId);
    }
}
