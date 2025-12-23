package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    // already used in services
    List<AssessmentResult> findByStudentProfileIdAndSkillId(
            Long studentId, Long skillId);

    // 🔥 REQUIRED BY TESTS
    @Query("""
        SELECT AVG(a.score)
        FROM AssessmentResult a
        WHERE a.studentProfile.grade = :cohort
          AND a.skill.id = :skillId
    """)
    Double avgScoreByCohortAndSkill(String cohort, Long skillId);

    // 🔥 REQUIRED BY TESTS
    @Query("""
        SELECT a FROM AssessmentResult a
        WHERE a.studentProfile.id = :studentId
        ORDER BY a.attemptedAt DESC
    """)
    List<AssessmentResult> findRecentByStudent(Long studentId);

    // already used
    @Query("""
        SELECT a FROM AssessmentResult a
        WHERE a.studentProfile.id = :studentId
          AND a.attemptedAt BETWEEN :start AND :end
    """)
    List<AssessmentResult> findResultsForStudentBetween(
            Long studentId, Instant start, Instant end);
}
