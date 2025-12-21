package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;
import java.util.List;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Long> {
    // names from errors
    List<AssessmentResult> findResultsForStudentBetween(long studentProfileId, Instant from, Instant to);
    List<AssessmentResult> findRecentByStudent(long studentProfileId);
    List<AssessmentResult> findByStudentProfileIdAndSkillId(long studentId, long skillId);
    Double avgScoreByCohortAndSkill(String cohort, long skillId); // if using @Query
    // Add @Query annotations where needed
}
