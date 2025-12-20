package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final AssessmentResultRepository assessmentRepository;
    private final SkillRepository skillRepository;
    private final SkillGapRecordRepository gapRepository;

    public SkillGapServiceImpl(AssessmentResultRepository assessmentRepository,
                               SkillRepository skillRepository,
                               SkillGapRecordRepository gapRepository) {
        this.assessmentRepository = assessmentRepository;
        this.skillRepository = skillRepository;
        this.gapRepository = gapRepository;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentProfileId) {
        List<Skill> skills = skillRepository.findAll(); // Or active skills
        List<AssessmentResult> results = assessmentRepository.findByStudentProfileId(studentProfileId);

        for (Skill skill : skills) {
            double currentScore = results.stream()
                    .filter(r -> r.getSkill().getId().equals(skill.getId()))
                    .mapToDouble(AssessmentResult::getScoreObtained)
                    .max().orElse(0.0);

            double targetScore = skill.getMinCompetencyScore();
            double gap = targetScore - currentScore;

            SkillGapRecord record = new SkillGapRecord();
            StudentProfile sp = new StudentProfile();
            sp.setId(studentProfileId);
            record.setStudentProfile(sp);
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
