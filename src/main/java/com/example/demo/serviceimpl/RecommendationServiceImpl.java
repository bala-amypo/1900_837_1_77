package com.example.demo.serviceimpl;

import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository repository;

    public RecommendationServiceImpl(SkillGapRecommendationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<?> computeRecommendationsForStudent(Long studentId) {
        return repository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }

    @Override
    public List<?> getRecommendationsForStudent(Long studentId) {
        return repository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}

