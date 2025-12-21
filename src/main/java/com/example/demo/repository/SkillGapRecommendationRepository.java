package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendationEntity;
import com.example.demo.entity.StudentProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillGapRecommendationRepository
        extends JpaRepository<SkillGapRecommendationEntity, Object> {

    List<SkillGapRecommendationEntity>
    findByStudentProfileOrderByGeneratedAtDesc(
            StudentProfileEntity studentProfile
    );
}
