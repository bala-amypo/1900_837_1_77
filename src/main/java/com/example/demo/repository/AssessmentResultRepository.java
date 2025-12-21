package com.example.demo.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.AssessmentResult;

public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    @Query("""
        SELECT ar
        FROM AssessmentResult ar
        WHERE ar.student.id = :studentId
          AND ar.createdAt BETWEEN :start AND :end
    """)
    List<AssessmentResult> findResultsForStudentBetween(
            @Param("studentId") long studentId,
            @Param("start") Instant start,
            @Param("end") Instant end
    );
}
