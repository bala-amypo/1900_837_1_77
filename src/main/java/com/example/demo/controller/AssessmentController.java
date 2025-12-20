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

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @PostMapping
    public ResponseEntity<AssessmentResult> record(
            @RequestBody AssessmentResult result
    ) {
        return ResponseEntity.ok(assessmentService.recordResult(result));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AssessmentResult>> getByStudent(
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(
                assessmentService.getResultsByStudent(studentId)
        );
    }

    @GetMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<AssessmentResult> getByStudentAndSkill(
            @PathVariable Long studentId,
            @PathVariable Long skillId
    ) {
        return ResponseEntity.ok(
                assessmentService.getResultByStudentAndSkill(studentId, skillId)
        );
    }
}
