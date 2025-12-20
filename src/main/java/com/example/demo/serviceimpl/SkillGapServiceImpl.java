package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapScore;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapScoreRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillGapService;

import java.util.ArrayList;
import java.util.List;

public class SkillGapServiceImpl implements SkillGapService {

    private final AssessmentResultRepository assessmentResultRepository;
    private final SkillRepository skillRepository;
    private final SkillGapScoreRepository skillGapScoreRepository;

    public SkillGapServiceImpl(
            AssessmentResultRepository assessmentResultRepository,
            SkillRepository skillRepository,
            SkillGapScoreRepository skillGapScoreRepository
    ) {
        this.assessmentResultRepository = assessmentResultRepository;
        this.skillRepository = skillRepository;
        this.skillGapScoreRepository = skillGapScoreRepository;
    }

    @Override
    public List<SkillGapScore> computeGapScores(Long studentProfileId) {

        List<AssessmentResult> results =
                assessmentResultRepository.findByStudentProfileId(studentProfileId);

        List<SkillGapScore> gaps = new ArrayList<>();

        for (AssessmentResult ar : results) {
            Skill skill = ar.getSkill();

            SkillGapScore gap = new SkillGapScore();
            gap.setStudentProfile(ar.getStudentProfile());
            gap.setSkill(skill);
            gap.setCurrentScore(ar.getScoreObtained());
            gap.setTargetScore(skill.getMinCompetencyScore());
            gap.setGapScore(skill.getMinCompetencyScore() - ar.getScoreObtained());

            gaps.add(skillGapScoreRepository.save(gap));
        }
        return gaps;
    }

    @Override
    public List<SkillGapScore> getGapScoresByStudent(Long studentId) {
        return skillGapScoreRepository
                .findByStudentProfileIdOrderByGapScoreDesc(studentId);
    }
}
