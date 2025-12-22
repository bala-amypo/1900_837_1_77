package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;
import org.springframework.stereotype.Service;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    // ✅ EXACT MATCH WITH INTERFACE
    @Override
    public AssessmentResult recordAssessment(AssessmentResult result) {

        if (result.getMaxScore() == null || result.getMaxScore() <= 0) {
            result.setMaxScore(100.0);
        }

        if (result.getScore() == null || result.getScore() < 0) {
            result.setScore(0.0);
        }

        return repository.save(result);
    }
}
