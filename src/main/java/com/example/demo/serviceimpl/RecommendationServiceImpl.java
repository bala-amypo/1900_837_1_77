package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepository;
    private final SkillGapRecommendationRepository recommendationRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final SkillRepository skillRepository;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepository,
            SkillGapRecommendationRepository recommendationRepository,
            StudentProfileRepository studentProfileRepository,
            SkillRepository skillRepository) {

        this.assessmentRepository = assessmentRepository;
        this.recommendationRepository = recommendationRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(
            Long studentProfileId, Long skillId) {

        StudentProfile profile = studentProfileRepository.findById(studentProfileId)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        double avgScore = assessmentRepository
                .findByStudentProfileIdAndSkillId(studentProfileId, skillId)
                .stream()
                .mapToDouble(a -> a.getScore())
                .average()
                .orElse(0.0);

        double gap = 100.0 - avgScore;

        SkillGapRecommendation recommendation =
                SkillGapRecommendation.builder()
                        .studentProfile(profile)
                        .skill(skill)
                        .gapScore(gap)
                        .generatedBy("SYSTEM")
                        .build();

        return recommendationRepository.save(recommendation);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(
            Long studentProfileId) {

        StudentProfile profile = studentProfileRepository.findById(studentProfileId)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        List<Skill> skills = skillRepository.findByActiveTrue();
        List<SkillGapRecommendation> result = new ArrayList<>();

        for (Skill skill : skills) {
            result.add(
                computeRecommendationForStudentSkill(profile.getId(), skill.getId())
            );
        }
        return result;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(
            Long studentProfileId) {

        return recommendationRepository
                .findByStudentProfileIdOrderByGeneratedAtDesc(studentProfileId);
    }
}
