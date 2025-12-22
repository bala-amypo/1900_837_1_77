package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import java.time.Instant;
import java.util.List;

public interface AssessmentResultRepository {

    AssessmentResult save(AssessmentResult result);

    List<AssessmentResult> findByStudentProfileIdAndSkillId(Long studentId, Long skillId);

    List<AssessmentResult> findRecentByStudent(Long studentId);

    List<AssessmentResult> findResultsForStudentBetween(Long studentId, Instant from, Instant to);

    double avgScoreByCohortAndSkill(String cohort, Long skillId);
}
