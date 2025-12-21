package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecordEntity;
import com.example.demo.entity.StudentProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillGapRecordRepository
        extends JpaRepository<SkillGapRecordEntity, Object> {

    List<SkillGapRecordEntity> findByStudentProfile(
            StudentProfileEntity studentProfile
    );
}
