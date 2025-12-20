package com.example.demo.service;

import java.util.List;

public interface RecommendationService {

    List<?> computeRecommendationsForStudent(Long studentId);

    List<?> getRecommendationsForStudent(Long studentId);
}

