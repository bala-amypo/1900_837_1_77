package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;

public class AssessmentServiceImpl {

    private final AssessmentResultRepository repo;

    public AssessmentServiceImpl(AssessmentResultRepository repo) {
        this.repo = repo;
    }

    public AssessmentResult recordAssessment(AssessmentResult result) {
        if (result.getScore() == null ||
            result.getScore() < 0 ||
            result.getScore() > result.getMaxScore()) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        return repo.save(result);
    }
}
