package com.example.demo.repository;

import com.example.demo.entity.AssessmentResultEntity;
import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResultEntity, Object> {

    List<AssessmentResultEntity> findByStudentProfile(
            StudentProfileEntity studentProfile
    );

    List<AssessmentResultEntity> findByStudentProfileAndSkill(
            StudentProfileEntity studentProfile,
            SkillEntity skill
    );
}
