package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    // REQUIRED BY TESTNG
    Double avgScoreByCohortAndSkill(String cohort, Long skillId);

    List<AssessmentResult> findRecentByStudent(Long studentId);

    List<AssessmentResult> findResultsForStudentBetween(
            Long studentId, Instant from, Instant to);

    List<AssessmentResult> findByStudentProfileIdAndSkillId(
            Long studentProfileId, Long skillId);
}
