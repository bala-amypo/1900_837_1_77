package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;

import java.util.List;

public interface AssessmentService {

    AssessmentResult create(AssessmentResult a);
    List<AssessmentResult> getAll();
    AssessmentResult getById(Long id);
    AssessmentResult update(Long id, AssessmentResult a);
    void delete(Long id);
}
