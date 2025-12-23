package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public AssessmentResult create(@RequestBody AssessmentResult result) {
        return service.recordAssessment(result);
    }
}
