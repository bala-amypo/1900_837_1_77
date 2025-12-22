package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import java.time.Instant;
import java.util.*;

public interface AssessmentResultRepository {

    List<AssessmentResult> findByStudentProfileId(Long studentId);
    List<AssessmentResult> findByStudentProfileIdAndSkillId(Long studentId, Long skillId);

    Double avgScoreByCohortAndSkill(String cohort, Long skillId);
    List<AssessmentResult> findRecentByStudent(Long studentId);
    List<AssessmentResult> findResultsForStudentBetween(Long studentId, Instant from, Instant to);

    AssessmentResult save(AssessmentResult result);
}
