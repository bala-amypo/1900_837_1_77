package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillGapRecordRepository
        extends JpaRepository<SkillGapRecord, Long> {

    // Fetch all gaps for student
    List<SkillGapRecord> findByStudentProfileId(Long studentProfileId);

    // REQUIRED by college tests
    List<SkillGapRecord> findByStudentProfileIdOrderByGapScoreDesc(
            Long studentProfileId
    );
}
