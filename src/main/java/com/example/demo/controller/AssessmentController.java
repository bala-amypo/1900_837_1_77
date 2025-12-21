package com.example.demo.controller;

import com.example.demo.entity.AssessmentResultEntity;
import com.example.demo.service.AssessmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AssessmentResultEntity> record(
            @RequestBody AssessmentResultEntity result) {
        return ResponseEntity.ok(service.recordResult(result));
    }

    @GetMapping("/student/{enrollmentId}")
    public ResponseEntity<List<AssessmentResultEntity>> getByStudent(
            @PathVariable String enrollmentId) {
        return ResponseEntity.ok(
                service.getResultsByStudent(enrollmentId));
    }

    @GetMapping("/student/{enrollmentId}/skill/{skillName}")
    public ResponseEntity<List<AssessmentResultEntity>> getByStudentAndSkill(
            @PathVariable String enrollmentId,
            @PathVariable String skillName) {
        return ResponseEntity.ok(
                service.getResultByStudentAndSkill(enrollmentId, skillName));
    }
}
