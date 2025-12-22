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

        // default values required by testcase
        if (result.getMaxScore() <= 0) {
            result.setMaxScore(100.0);
        }

        if (result.getScore() < 0) {
            result.setScore(0);
        }

        return assessmentResultRepository.save(result);
    }
}
