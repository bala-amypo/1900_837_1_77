package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecommendation;
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

    @PostMapping("/student/{studentId}")
    public ResponseEntity<List<SkillGapRecommendation>> generate(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(
                service.computeRecommendationsForStudent(studentId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<SkillGapRecommendation>> getAll(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(
                service.getRecommendationsForStudent(studentId));
    }
}
