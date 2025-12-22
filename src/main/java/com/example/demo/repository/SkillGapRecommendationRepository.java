package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.*;

public interface SkillGapRecommendationRepository {
    SkillGapRecommendation save(SkillGapRecommendation rec);
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);
}
