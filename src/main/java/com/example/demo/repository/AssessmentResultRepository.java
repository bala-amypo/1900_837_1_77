package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Long> {

    List<AssessmentResult> findByStudentProfileIdAndSkillId(Long studentId, Long skillId);

    List<AssessmentResult> findByStudentProfileId(Long studentId);

    List<AssessmentResult> findResultsForStudentBetween(
            Long studentId, Instant start, Instant end
    );

    Double avgScoreByCohortAndSkill(String cohort, Long skillId);
}
