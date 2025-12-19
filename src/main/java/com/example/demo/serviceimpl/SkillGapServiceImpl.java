package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillGapService;

import java.util.List;

public class SkillGapServiceImpl implements SkillGapService {

    private final AssessmentResultRepository assessmentRepository;
    private final SkillRepository skillRepository;
    private final SkillGapRecordRepository gapRepository;

    // 🔑 EXACT constructor order (IMPORTANT)
    public SkillGapServiceImpl(
            AssessmentResultRepository assessmentRepository,
            SkillRepository skillRepository,
            SkillGapRecordRepository gapRepository) {

        this.assessmentRepository = assessmentRepository;
        this.skillRepository = skillRepository;
        this.gapRepository = gapRepository;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentProfileId) {

        List<Skill> skills = skillRepository.findByActiveTrue();

        for (Skill skill : skills) {

            List<AssessmentResult> results =
                    assessmentRepository.findByStudentProfileIdAndSkillId(
                            studentProfileId, skill.getId());

            double currentScore = 0.0;
            if (!results.isEmpty()) {
                currentScore = results.get(results.size() - 1).getScoreObtained();
            }

            double targetScore = skill.getMinCompetencyScore();
            double gap = targetScore - currentScore;

            SkillGapRecord record = new SkillGapRecord();
            record.setSkill(skill);
            record.setCurrentScore(currentScore);
            record.setTargetScore(targetScore);
            record.setGapScore(gap);

            gapRepository.save(record);
        }

        return gapRepository.findByStudentProfileId(studentProfileId);
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentId) {
        return gapRepository.findByStudentProfileId(studentId);
    }
}
