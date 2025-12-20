package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Long> {

    @Query("""
        SELECT AVG(a.score)
        FROM AssessmentResult a
        WHERE a.studentProfile.cohort = :cohort
        AND a.skill.id = :skillId
    """)
    Double avgScoreByCohortAndSkill(@Param("cohort") String cohort,
                                    @Param("skillId") Long skillId);

    List<AssessmentResult> findRecentByStudentProfileId(Long studentId);

    List<AssessmentResult> findResultsForStudentBetween(
            Long studentId, Instant start, Instant end);
}
