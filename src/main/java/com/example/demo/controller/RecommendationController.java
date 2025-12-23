package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.service.RecommendationService;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/{studentId}")
    public List<SkillGapRecommendation> get(@PathVariable Long studentId) {
        return service.computeRecommendationsForStudent(studentId);
    }
}
