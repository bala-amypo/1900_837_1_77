package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    List<AssessmentResult> findByStudentProfileId(Long studentId);

    @Query("""
        SELECT AVG(a.score)
        FROM AssessmentResult a
        WHERE a.studentProfile.cohort = ?1 AND a.skill.id = ?2
    """)
    Double avgScoreByCohortAndSkill(String cohort, Long skillId);

    List<AssessmentResult> findResultsForStudentBetween(
            Long studentId, Instant start, Instant end
    );
}
