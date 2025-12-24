package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping("/generate/{id}")
    public List<SkillGapRecommendation> generate(@PathVariable Long id) {
        return service.computeRecommendationsForStudent(id);
    }

    @GetMapping("/student/{id}")
    public List<SkillGapRecommendation> get(@PathVariable Long id) {
        return service.getRecommendationsForStudent(id);
    }
}
