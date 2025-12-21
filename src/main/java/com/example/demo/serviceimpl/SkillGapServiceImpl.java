package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillRepository skillRepo;
    private final SkillGapRecordRepository gapRepo;
    private final StudentProfileRepository studentRepo;

    public SkillGapServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillRepository skillRepo,
            SkillGapRecordRepository gapRepo,
            StudentProfileRepository studentRepo
    ) {
        this.assessmentRepo = assessmentRepo;
        this.skillRepo = skillRepo;
        this.gapRepo = gapRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public List<SkillGapRecordEntity> computeGapScores(String enrollmentId) {

        StudentProfileEntity student =
                studentRepo.findByEnrollmentId(enrollmentId)
                        .orElseThrow(() -> new IllegalArgumentException("Not Found"));

        List<SkillGapRecordEntity> records = new ArrayList<>();

        for (SkillEntity skill : skillRepo.findByActiveTrue()) {

            List<AssessmentResultEntity> results =
                    assessmentRepo.findByStudentProfileAndSkill(student, skill);

            if (results.isEmpty()) continue;

            double current = results.get(0).getScoreObtained();
            double target = skill.getMinCompetencyScore();

            SkillGapRecordEntity record = new SkillGapRecordEntity();
            record.setStudentProfile(student);
            record.setSkill(skill);
            record.setCurrentScore(current);
            record.setTargetScore(target);
            record.setGapScore(target - current);

            records.add(gapRepo.save(record));
        }

        return records;
    }

    @Override
    public List<SkillGapRecordEntity> getGapScoresByStudent(String enrollmentId) {

        StudentProfileEntity student =
                studentRepo.findByEnrollmentId(enrollmentId)
                        .orElseThrow(() -> new IllegalArgumentException("Not Found"));

        return gapRepo.findByStudentProfile(student);
    }
}
