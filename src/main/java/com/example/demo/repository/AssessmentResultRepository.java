package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    @Query("""
        SELECT AVG(ar.score)
        FROM AssessmentResult ar
        WHERE ar.studentProfile.cohort = :cohort
          AND ar.skill.id = :skillId
    """)
    Double avgScoreByCohortAndSkill(
            @Param("cohort") String cohort,
            @Param("skillId") Long skillId
    );
}
