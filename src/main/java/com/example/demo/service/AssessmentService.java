package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;

public interface AssessmentService {

    AssessmentResult recordAssessment(AssessmentResult result);

    Double getAverageScore(String cohort, Long skillId);
}
