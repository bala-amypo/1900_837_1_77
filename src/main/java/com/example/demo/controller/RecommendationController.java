package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SkillGapRecommendationEntity;
import com.example.demo.service.RecommendationService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/recommendations")
@Tag(name = "Recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping("/generate/{studentId}")
    public ResponseEntity<List<SkillGapRecommendationEntity>> generate(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(
                service.computeRecommendationsForStudent(studentId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<SkillGapRecommendationEntity>> getByStudent(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(
                service.getRecommendationsForStudent(studentId));
    }
}
