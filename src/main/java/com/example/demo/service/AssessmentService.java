package com.example.demo.service;

import com.example.demo.entity.AssessmentResultEntity;

import java.util.List;

public interface AssessmentService {

    AssessmentResultEntity recordResult(AssessmentResultEntity result);

    List<AssessmentResultEntity> getResultsByStudent(String enrollmentId);

    List<AssessmentResultEntity> getResultByStudentAndSkill(
            String enrollmentId,
            String skillName
    );
}
