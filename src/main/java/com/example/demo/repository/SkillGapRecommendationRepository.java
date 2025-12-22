package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.SkillGapRecommendation;

public interface SkillGapRecommendationRepository
        extends JpaRepository<SkillGapRecommendation, Long> {

    // REQUIRED by testcases
    List<SkillGapRecommendation> findByStudentIdOrderByIdDesc(Long studentId);
}
