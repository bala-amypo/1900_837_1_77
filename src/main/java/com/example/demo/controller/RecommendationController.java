package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecommendationEntity;
import com.example.demo.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping("/student/{enrollmentId}")
    public ResponseEntity<List<SkillGapRecommendationEntity>> generate(
            @PathVariable String enrollmentId) {
        return ResponseEntity.ok(
                service.generateRecommendations(enrollmentId));
    }

    @GetMapping("/student/{enrollmentId}")
    public ResponseEntity<List<SkillGapRecommendationEntity>> getAll(
            @PathVariable String enrollmentId) {
        return ResponseEntity.ok(
                service.getRecommendationsByStudent(enrollmentId));
    }
}
