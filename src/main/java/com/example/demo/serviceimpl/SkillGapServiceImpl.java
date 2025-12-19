package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillGapServiceImpl {

    private final AssessmentResultRepository assessmentRepository;
    private final SkillGapRecordRepository gapRepository;

    public SkillGapServiceImpl(AssessmentResultRepository assessmentRepository,
                               SkillGapRecordRepository gapRepository) {
        this.assessmentRepository = assessmentRepository;
        this.gapRepository = gapRepository;
    }

    public SkillGapRecord calculateSkillGap(Long profileId, Long skillId) {

        Optional<AssessmentResult> assessment =
                assessmentRepository.findByStudentProfileIdAndSkillId(profileId, skillId);

        if (assessment.isEmpty()) {
            throw new RuntimeException("Assessment not found");
        }

        AssessmentResult result = assessment.get();

        SkillGapRecord record = new SkillGapRecord();
        record.setSkill(result.getSkill());
        record.setCurrentScore(result.getScore());
        record.setTargetScore(100);
        record.setGapScore(100 - result.getScore());

        return gapRepository.save(record);
    }
}
