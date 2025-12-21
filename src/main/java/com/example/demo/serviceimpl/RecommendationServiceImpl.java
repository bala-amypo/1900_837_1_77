package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecordRepository skillGapRecordRepository;
    private final SkillGapRecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(
            SkillGapRecordRepository skillGapRecordRepository,
            SkillGapRecommendationRepository recommendationRepository) {
        this.skillGapRecordRepository = skillGapRecordRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<SkillGapRecommendation> generateRecommendations(Long studentProfileId) {

        List<SkillGapRecord> gaps =
                skillGapRecordRepository.findByStudentProfileId(studentProfileId);

        for (SkillGapRecord gap : gaps) {

            if (gap.getGapScore() != null && gap.getGapScore() > 0) {

                SkillGapRecommendation recommendation = SkillGapRecommendation.builder()
                        .studentProfile(gap.getStudentProfile())
                        .skill(gap.getSkill())
                        .gapScore(gap.getGapScore())
                        .priority(gap.getGapScore() > 50 ? "HIGH" : "MEDIUM")
                        .recommendationText(
                                "Improve skill: " + gap.getSkill().getName()
                        )
                        .generatedBy("SYSTEM")
                        .build();

                recommendationRepository.save(recommendation);
            }
        }

        return recommendationRepository
                .findByStudentProfileId(studentProfileId);
    }
}
