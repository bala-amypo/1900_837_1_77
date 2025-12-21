package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.SkillGapRecommendationEntity;

public interface RecommendationService {

    SkillGapRecommendationEntity computeRecommendationForStudentSkill(
            Long studentId, Long skillId);

    List<SkillGapRecommendationEntity> computeRecommendationsForStudent(Long studentId);

    List<SkillGapRecommendationEntity> getRecommendationsForStudent(Long studentId);
}
