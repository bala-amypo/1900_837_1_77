package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SkillGapRecordEntity;

public interface SkillGapRecordRepository
        extends JpaRepository<SkillGapRecordEntity, Long> {

    List<SkillGapRecordEntity> findByStudentProfileId(Long studentProfileId);
}
