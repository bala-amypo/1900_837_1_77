package com.example.demo.service;

import com.example.demo.entity.SkillRecommendation;

import java.util.List;

public interface RecommendationService {

    List<SkillRecommendation> generateRecommendations(Long studentProfileId);

    List<SkillRecommendation> getRecommendationsByStudent(Long studentId);
}
