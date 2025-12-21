package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AssessmentResultEntity;

public interface AssessmentService {

    AssessmentResultEntity recordAssessment(AssessmentResultEntity assessment);

    List<AssessmentResultEntity> getResultsByStudent(Long studentProfileId);

    List<AssessmentResultEntity> getResultsByStudentAndSkill(
            Long studentProfileId, Long skillId);
}
