package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AssessmentResultEntity;

public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResultEntity, Long> {

    List<AssessmentResultEntity> findByStudentProfileId(Long studentProfileId);

    List<AssessmentResultEntity> findByStudentProfileIdAndSkillId(
            Long studentProfileId, Long skillId);
}
