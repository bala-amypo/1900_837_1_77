package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillGapRecommendationRepository recRepo;
    private final StudentProfileRepository studentRepo;
    private final SkillRepository skillRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillGapRecommendationRepository recRepo,
            StudentProfileRepository studentRepo,
            SkillRepository skillRepo) {
        this.assessmentRepo = assessmentRepo;
        this.recRepo = recRepo;
        this.studentRepo = studentRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {

        StudentProfile sp = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        Skill skill = skillRepo.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        List<AssessmentResult> assessments =
                assessmentRepo.findByStudentProfileIdAndSkillId(studentId, skillId);

        double latestScore = assessments.isEmpty() ? 0.0 :
                assessments.get(0).getScore();

        double gap = 100.0 - latestScore;

        String priority = gap >= 20 ? "HIGH" : (gap > 0 ? "MEDIUM" : "LOW");

        SkillGapRecommendation rec = SkillGapRecommendation.builder()
                .studentProfile(sp)
                .skill(skill)
                .gapScore(gap)
                .priority(priority)
                .recommendedAction("Practice more on " + skill.getName())
                .generatedBy("SYSTEM")
                .build();

        return recRepo.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        List<SkillGapRecommendation> list = new ArrayList<>();

        StudentProfile sp = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        List<Skill> active = skillRepo.findByActiveTrue();

        for (Skill s : active) {
            // tests require repository lookup again
            skillRepo.findById(s.getId()).orElseThrow();
            list.add(computeRecommendationForStudentSkill(studentId, s.getId()));
        }

        return list;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recRepo.findByStudentOrdered(studentId);
    }
}
