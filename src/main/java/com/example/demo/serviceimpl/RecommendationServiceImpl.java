package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository repo;

    public RecommendationServiceImpl(SkillGapRecommendationRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {
        return repo.findByStudentProfileIdOrderByIdDesc(studentId);
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return repo.findByStudentProfileIdOrderByIdDesc(studentId);
    }
}
