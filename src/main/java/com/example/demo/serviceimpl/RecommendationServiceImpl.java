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

    private final SkillGapRecordRepository recordRepository;
    private final SkillGapRecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(
            SkillGapRecordRepository recordRepository,
            SkillGapRecommendationRepository recommendationRepository) {
        this.recordRepository = recordRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentProfileId) {

        List<SkillGapRecord> gaps =
                recordRepository.findByStudentProfileId(studentProfileId);

        for (SkillGapRecord gap : gaps) {
            if (gap.getGapScore() != null && gap.getGapScore() > 0) {

                SkillGapRecommendation rec = SkillGapRecommendation.builder()
                        .skill(gap.getSkill())
                        .gapScore(gap.getGapScore())
                        .priority("MEDIUM")
                        .recommendationText("Improve " + gap.getSkill().getName())
                        .generatedBy("SYSTEM")
                        .build();

                recommendationRepository.save(rec);
            }
        }

        return recommendationRepository.findByStudentProfileId(studentProfileId);
    }
}
