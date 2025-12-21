package com.example.demo.service;

public interface RecommendationService {

    void computeRecommendationForStudentSkill(Long studentId, Long skillId);

    void computeRecommendationsForStudent(Long studentId);
}
