package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository recommendationRepository;
    private final SkillRepository skillRepository;

    public RecommendationServiceImpl(
            SkillGapRecommendationRepository recommendationRepository,
            SkillRepository skillRepository) {
        this.recommendationRepository = recommendationRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(
            Long studentId, Long skillId) {

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        // ✅ FIX 1: NO builder(), use setters
        SkillGapRecommendation rec = new SkillGapRecommendation();
        rec.setStudentId(studentId);
        rec.setSkill(skill);
        rec.setGapScore(50.0);
        rec.setGeneratedBy("SYSTEM");
        rec.setGeneratedAt(Instant.now());

        return recommendationRepository.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        List<Skill> skills = skillRepository.findAll();
        List<SkillGapRecommendation> result = new ArrayList<>();

        for (Skill skill : skills) {
            result.add(
                    computeRecommendationForStudentSkill(studentId, skill.getId())
            );
        }
        return result;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {

        // ✅ FIX 2: call the CORRECT repository method
        return recommendationRepository
                .findByStudentIdOrderByGeneratedAtDesc(studentId);
    }
}
