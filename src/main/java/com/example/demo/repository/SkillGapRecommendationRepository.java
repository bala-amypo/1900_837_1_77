package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {

    List<SkillGapRecommendation> findByStudentProfileIdOrderByIdDesc(Long studentId);
}
