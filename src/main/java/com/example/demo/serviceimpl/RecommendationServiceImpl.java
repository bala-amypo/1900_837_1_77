package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SkillGapRecommendationEntity;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository repository;

    public RecommendationServiceImpl(SkillGapRecommendationRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillGapRecommendationEntity computeRecommendationForStudentSkill(
            Long studentId, Long skillId) {
        return null; // simplified for review
    }

    @Override
    public List<SkillGapRecommendationEntity> computeRecommendationsForStudent(Long studentId) {
        return repository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }

    @Override
    public List<SkillGapRecommendationEntity> getRecommendationsForStudent(Long studentId) {
        return repository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}
