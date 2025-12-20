package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;

import java.util.List;

public interface AssessmentService {

    AssessmentResult saveAssessment(AssessmentResult assessmentResult);

    List<AssessmentResult> getAllAssessments();

    AssessmentResult getAssessmentById(Long id);

    AssessmentResult updateAssessment(Long id, AssessmentResult assessmentResult);

    void deleteAssessment(Long id);
}
