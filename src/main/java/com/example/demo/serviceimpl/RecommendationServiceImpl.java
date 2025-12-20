package com.example.demo.serviceimpl;

import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepository;

    public RecommendationServiceImpl(AssessmentResultRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public String recommendSkills(Long studentProfileId) {
        // simple mock implementation
        return "Recommended skills for student " + studentProfileId;
    }
}
