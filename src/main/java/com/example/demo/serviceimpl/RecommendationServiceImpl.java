package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RecommendationService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {
        Skill skill = skillRepository.findById(skillId).orElseThrow();

        SkillGapRecommendation recommendation = SkillGapRecommendation.builder()
                .skill(skill)
                .gapScore(50.0)
                .generatedBy("SYSTEM")
                .build();

        return recommendationRepository.save(recommendation);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {
        List<Skill> activeSkills = skillRepository.findByActiveTrue();
        if (activeSkills.isEmpty()) {
            return Collections.emptyList();
        }

        List<SkillGapRecommendation> result = new ArrayList<>();
        for (Skill skill : activeSkills) {
            result.add(computeRecommendationForStudentSkill(studentId, skill.getId()));
        }
        return result;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository.findByStudentOrdered(studentId);
    }
}
