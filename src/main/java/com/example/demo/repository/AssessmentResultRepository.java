package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Long> {
    Optional<AssessmentResult> findByStudentProfileAndSkill(StudentProfile studentProfile, Skill skill);
}
