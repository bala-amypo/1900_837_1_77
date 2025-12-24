package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @PostMapping("/")
    public AssessmentResult create(@RequestBody AssessmentResult ar) {
        return service.recordAssessment(ar);
    }

    @GetMapping("/student/{studentId}")
    public List<AssessmentResult> getByStudent(@PathVariable Long studentId) {
        return service.getResultsByStudent(studentId);
    }

    @GetMapping("/student/{studentId}/skill/{skillId}")
    public List<AssessmentResult> getByStudentAndSkill(
            @PathVariable Long studentId,
            @PathVariable Long skillId) {
        return service.getResultsByStudentAndSkill(studentId, skillId);
    }
}
