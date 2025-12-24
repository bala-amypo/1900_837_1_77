package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository gapRepo;
    private final SkillRepository skillRepo;
    private final AssessmentResultRepository assessRepo;

    public SkillGapServiceImpl(
            SkillGapRecordRepository gapRepo,
            SkillRepository skillRepo,
            AssessmentResultRepository assessRepo) {

        this.gapRepo = gapRepo;
        this.skillRepo = skillRepo;
        this.assessRepo = assessRepo;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentId) {

        List<SkillGapRecord> list = new ArrayList<>();
        List<Skill> skills = skillRepo.findByActiveTrue();

        for (Skill skill : skills) {

            List<AssessmentResult> results =
                    assessRepo.findByStudentProfileIdAndSkillId(studentId, skill.getId());

            double score = results.isEmpty() ? 0 : results.get(results.size() - 1).getScore();
            double gap = (skill.getMinCompetencyScore() == null ? 100 : skill.getMinCompetencyScore()) - score;

            SkillGapRecord record = SkillGapRecord.builder()
                    .skill(skill)
                    .currentScore(score)
                    .targetScore(skill.getMinCompetencyScore())
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
