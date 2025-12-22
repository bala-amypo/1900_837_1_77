package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;

public interface AssessmentService {

    // ✅ ONLY THIS METHOD IS REQUIRED BY TESTCASE
    AssessmentResult recordAssessment(AssessmentResult result);
}
