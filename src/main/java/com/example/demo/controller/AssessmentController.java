package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssessmentResultEntity;
import com.example.demo.service.AssessmentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/assessments")
@Tag(name = "Assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AssessmentResultEntity> create(
            @RequestBody AssessmentResultEntity assessment) {
        return ResponseEntity.ok(service.recordAssessment(assessment));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AssessmentResultEntity>> getByStudent(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(service.getResultsByStudent(studentId));
    }

    @GetMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<List<AssessmentResultEntity>> getByStudentAndSkill(
            @PathVariable Long studentId,
            @PathVariable Long skillId) {
        return ResponseEntity.ok(
                service.getResultsByStudentAndSkill(studentId, skillId));
    }
}
