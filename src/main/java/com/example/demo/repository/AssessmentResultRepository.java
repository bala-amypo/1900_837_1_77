package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    // ✅ FIXED JPQL (FIELD EXISTS)
    @Query("""
        SELECT AVG(ar.score)
        FROM AssessmentResult ar
        WHERE ar.studentProfile.groupName = :groupName
          AND ar.skill.id = :skillId
    """)
    Double avgScoreByGroupAndSkill(
            @Param("groupName") String groupName,
            @Param("skillId") Long skillId
    );
}
