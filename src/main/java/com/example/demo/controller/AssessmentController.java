package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    // ✅ Constructor Injection (MANDATORY for your project)
    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    // ✅ Record assessment
    @PostMapping
    public ResponseEntity<AssessmentResult> recordAssessment(
            @RequestBody AssessmentResult result) {

        AssessmentResult saved =
                assessmentService.recordAssessment(result);

        return ResponseEntity.ok(saved);
    }

    // ✅ Get all results for a student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AssessmentResult>> getByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                assessmentService.getResultsByStudent(studentId)
        );
    }

    // ✅ Get result for a student + skill
    @GetMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<AssessmentResult> getByStudentAndSkill(
            @PathVariable Long studentId,
            @PathVariable Long skillId) {

        return ResponseEntity.ok(
                assessmentService.getResultsByStudentAndSkill(studentId, skillId)
        );
    }
}
