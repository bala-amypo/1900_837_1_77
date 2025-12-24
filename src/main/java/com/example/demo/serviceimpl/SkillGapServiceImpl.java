package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.SkillGapService;

import java.util.*;

public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository gapRepo;
    private final SkillRepository skillRepo;
    private final AssessmentResultRepository assessmentRepo;

    public SkillGapServiceImpl(
            SkillGapRecordRepository gapRepo,
            SkillRepository skillRepo,
            AssessmentResultRepository assessmentRepo) {

        this.gapRepo = gapRepo;
        this.skillRepo = skillRepo;
        this.assessmentRepo = assessmentRepo;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentId) {
        List<Skill> skills = skillRepo.findByActiveTrue();
        List<SkillGapRecord> list = new ArrayList<>();

        for (Skill s : skills) {
            List<AssessmentResult> results =
                    assessmentRepo.findByStudentProfileIdAndSkillId(studentId, s.getId());

            double currentScore = results.isEmpty() ? 0 : results.get(results.size() - 1).getScore();
            double target = s.getMinCompetencyScore() == null ? 100 : s.getMinCompetencyScore();
            double gap = target - currentScore;

            SkillGapRecord record = SkillGapRecord.builder()
                    .skill(s)
                    .currentScore(currentScore)
                    .targetScore(target)
                    .gapScore(gap)
                    .build();

            list.add(gapRepo.save(record));
        }

        return list;
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentId) {
        return gapRepo.findByStudentProfileId(studentId);
    }
}
