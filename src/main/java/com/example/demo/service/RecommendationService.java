package com.example.demo.service;

import com.example.demo.entity.SkillGapRecommendationEntity;

import java.util.List;

public interface RecommendationService {

    List<SkillGapRecommendationEntity> generateRecommendations(String enrollmentId);

    List<SkillGapRecommendationEntity> getRecommendationsByStudent(String enrollmentId);
}
