package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapScore;
import com.example.demo.entity.SkillRecommendation;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;

import java.util.ArrayList;
import java.util.List;

public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentResultRepository;
    private final SkillGapScoreRepository skillGapScoreRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final SkillRepository skillRepository;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentResultRepository,
            SkillGapScoreRepository skillGapScoreRepository,
            StudentProfileRepository studentProfileRepository,
            SkillRepository skillRepository
    ) {
        this.assessmentResultRepository = assessmentResultRepository;
        this.skillGapScoreRepository = skillGapScoreRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public List<SkillRecommendation> generateRecommendations(Long studentProfileId) {

        List<SkillGapScore> gaps =
                skillGapScoreRepository.findByStudentProfileIdOrderByGapScoreDesc(studentProfileId);

        List<SkillRecommendation> recommendations = new ArrayList<>();

        for (SkillGapScore gap : gaps) {
            SkillRecommendation rec = new SkillRecommendation();

            rec.setStudentProfile(gap.getStudentProfile());
            rec.setSkill(gap.getSkill());
            rec.setGapScore(gap.getGapScore());
            rec.setGeneratedBy("SYSTEM");

            if (gap.getGapScore() >= 20) {
                rec.setPriority("HIGH");
                rec.setRecommendationText("Immediate training required");
            } else if (gap.getGapScore() >= 10) {
                rec.setPriority("MEDIUM");
                rec.setRecommendationText("Practice recommended");
            } else {
                rec.setPriority("LOW");
                rec.setRecommendationText("Minor improvement needed");
            }

            recommendations.add(rec);
        }
        return recommendations;
    }

    @Override
    public List<SkillRecommendation> getRecommendationsByStudent(Long studentId) {
        return skillGapScoreRepository.findByStudentProfileIdOrderByGapScoreDesc(studentId)
                .stream()
                .map(g -> {
                    SkillRecommendation r = new SkillRecommendation();
                    r.setSkill(g.getSkill());
                    r.setGapScore(g.getGapScore());
                    return r;
                }).toList();
    }
}
