package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;  // ⭐ REQUIRED IMPORT
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessRepo;
    private final SkillGapRecommendationRepository recRepo;
    private final StudentProfileRepository profileRepo;
    private final SkillRepository skillRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessRepo,
            SkillGapRecommendationRepository recRepo,
            StudentProfileRepository profileRepo,
            SkillRepository skillRepo) {

        this.assessRepo = assessRepo;
        this.recRepo = recRepo;
        this.profileRepo = profileRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {

        StudentProfile sp = profileRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        Skill skill = skillRepo.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        List<AssessmentResult> results =
                assessRepo.findByStudentProfileIdAndSkillId(studentId, skillId);

        double score = results.isEmpty() ? 0 : results.get(results.size() - 1).getScore();
        double gap = 100 - score;

        String priority = gap >= 20 ? "HIGH" : gap >= 10 ? "MEDIUM" : "LOW";

        SkillGapRecommendation rec = SkillGapRecommendation.builder()
        .studentProfile(sp)
        .skill(skill)
        .gapScore(gap)
        .priority(priority)
        .recommendedAction("Improve " + skill.getName())
        .generatedBy("SYSTEM")
        .generatedAt(Instant.now())   // FIX
        .build();


        return recRepo.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        profileRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        List<Skill> skills = skillRepo.findByActiveTrue();
        List<SkillGapRecommendation> list = new ArrayList<>();

        for (Skill s : skills) {
            list.add(computeRecommendationForStudentSkill(studentId, s.getId()));
        }

        return list;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recRepo.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}
