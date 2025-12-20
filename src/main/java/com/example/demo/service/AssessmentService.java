package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;

import java.util.List;

public interface AssessmentService {

    AssessmentResult recordResult(AssessmentResult result);

    List<AssessmentResult> getResultsByStudent(Long studentId);

    AssessmentResult getResultByStudentAndSkill(Long studentId, Long skillId);
}
