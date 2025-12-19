package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecommendationServiceImpl {

    private final AssessmentResultRepository assessmentRepository;
    private final SkillGapRecordRepository gapRepository;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepository,
            SkillGapRecordRepository gapRepository) {
        this.assessmentRepository = assessmentRepository;
        this.gapRepository = gapRepository;
    }

    public SkillGapRecord generateRecommendation(Long profileId, Long skillId) {

        Optional<AssessmentResult> assessmentOpt =
                assessmentRepository.findByStudentProfileIdAndSkillId(profileId, skillId);

        if (assessmentOpt.isEmpty()) {
            throw new RuntimeException("Assessment not found");
        }

        AssessmentResult assessment = assessmentOpt.get();
        Skill skill = assessment.getSkill();

        double gap = skill.getMinCompetencyScore() - assessment.getScore();

        SkillGapRecord record = new SkillGapRecord();
        record.setSkill(skill);
        record.setCurrentScore(assessment.getScore());
        record.setTargetScore(skill.getMinCompetencyScore());
        record.setGapScore(Math.max(gap, 0));

        return gapRepository.save(record);
    }
}
