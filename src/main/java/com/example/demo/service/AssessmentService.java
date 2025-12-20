package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;
import java.util.List;

public interface AssessmentService {

    List<AssessmentResult> getResultsByStudent(Long studentProfileId);

    AssessmentResult getResultsByStudentAndSkill(Long studentProfileId, Long skillId);

    Double calculatePercentage(AssessmentResult result);
}
