package com.example.demo.repository;

import com.example.demo.entity.SkillGapScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillGapScoreRepository extends JpaRepository<SkillGapScore, Long> {

    List<SkillGapScore> findByStudentProfileIdOrderByGapScoreDesc(Long studentProfileId);
}
