package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @PostMapping
    public AssessmentResult create(@RequestBody AssessmentResult assessmentResult) {
        return assessmentService.saveAssessment(assessmentResult);
    }

    @GetMapping
    public List<AssessmentResult> getAll() {
        return assessmentService.getAllAssessments();
    }
}
