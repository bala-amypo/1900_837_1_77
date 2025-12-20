package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;
import java.util.List;

public interface AssessmentService {

    AssessmentResult recordAssessment(AssessmentResult result);

    List<AssessmentResult> getResultsByStudent(Long studentProfileId);

    AssessmentResult getResultsByStudentAndSkill(Long studentProfileId, Long skillId);

    Double calculatePercentage(AssessmentResult result);
}
