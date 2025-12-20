package com.example.demo.controller;

import com.example.demo.entity.SkillRecommendation;
import com.example.demo.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/student/{studentId}")
    public ResponseEntity<List<SkillRecommendation>> generate(
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(
                recommendationService.generateRecommendations(studentId)
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<SkillRecommendation>> get(
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(
                recommendationService.getRecommendationsByStudent(studentId)
        );
    }
}
