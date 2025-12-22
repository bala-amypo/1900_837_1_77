package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.util.*;

public class RecommendationServiceImpl {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillGapRecommendationRepository recRepo;
    private final StudentProfileRepository profileRepo;
    private final SkillRepository skillRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillGapRecommendationRepository recRepo,
            StudentProfileRepository profileRepo,
            SkillRepository skillRepo) {
        this.assessmentRepo = assessmentRepo;
        this.recRepo = recRepo;
        this.profileRepo = profileRepo;
        this.skillRepo = skillRepo;
    }

    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {

        StudentProfile sp = profileRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("not found"));
        Skill skill = skillRepo.findById(skillId)
                .orElseThrow(() -> new RuntimeException("not found"));

        List<AssessmentResult> results =
                assessmentRepo.findByStudentProfileIdAndSkillId(studentId, skillId);

        double score = results.isEmpty() ? 0 : results.get(0).getScore();
        double gap = 100 - score;

        SkillGapRecommendation rec = SkillGapRecommendation.builder()
                .studentProfile(sp)
                .skill(skill)
                .gapScore(gap)
                .priority(gap >= 20 ? "HIGH" : "LOW")
                .generatedBy("SYSTEM")
                .build();

        return recRepo.save(rec);
    }

    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        profileRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("not found"));

        List<Skill> skills = skillRepo.findByActiveTrue();
        List<SkillGapRecommendation> out = new ArrayList<>();

        for (Skill s : skills) {
            out.add(computeRecommendationForStudentSkill(studentId, s.getId()));
        }
        return out;
    }

    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recRepo.findByStudentOrdered(studentId);
    }
}
