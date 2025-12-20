package com.example.demo.serviceimpl;

import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ THIS ANNOTATION IS REQUIRED
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepository;

    public RecommendationServiceImpl(AssessmentResultRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public List<String> getRecommendations(Long studentProfileId) {
        return List.of("Practice Java", "Improve Spring Boot", "Learn SQL");
    }
}
