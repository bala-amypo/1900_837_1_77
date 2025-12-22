package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;
import org.springframework.stereotype.Service;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository assessmentResultRepository;

    public AssessmentServiceImpl(AssessmentResultRepository assessmentResultRepository) {
        this.assessmentResultRepository = assessmentResultRepository;
    }

    @Override
    public AssessmentResult recordAssessment(AssessmentResult result) {
        return assessmentResultRepository.save(result);
    }

    @Override
    public Double getAverageScore(String cohort, Long skillId) {
        return assessmentResultRepository.avgScoreByCohortAndSkill(cohort, skillId);
    }
}
