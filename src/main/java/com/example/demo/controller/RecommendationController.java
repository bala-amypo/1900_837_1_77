package com.example.demo.controller;

import com.example.demo.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{studentId}")
    public String getRecommendations(@PathVariable Long studentId) {
        return recommendationService.recommendSkills(studentId);
    }
}
