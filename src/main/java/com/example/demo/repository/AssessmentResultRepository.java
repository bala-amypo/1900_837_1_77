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

    List<AssessmentResult> findByStudentProfileIdAndSkillId(
            Long studentId, Long skillId);

    @Query("""
        SELECT a FROM AssessmentResult a
        WHERE a.studentProfile.id = :studentId
        ORDER BY a.attemptedAt DESC
    """)
    List<AssessmentResult> findRecentByStudent(Long studentId);

    @Query("""
        SELECT AVG(a.score) FROM AssessmentResult a
        WHERE a.skill.id = :skillId
    """)
    Double avgScoreBySkill(Long skillId);

    @Query("""
        SELECT a FROM AssessmentResult a
        WHERE a.studentProfile.id = :studentId
          AND a.attemptedAt BETWEEN :start AND :end
    """)
    List<AssessmentResult> findResultsForStudentBetween(
            Long studentId, Instant start, Instant end);
}
