package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentProfileRepository
        extends JpaRepository<StudentProfile, Long> {

    // REQUIRED by college tests
    Optional<StudentProfile> findByEnrollmentId(String enrollmentId);

    // Used internally
    Optional<StudentProfile> findByUserId(Long userId);

    // Used while creating profile
    boolean existsByEnrollmentId(String enrollmentId);
}
