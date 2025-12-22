package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    // REQUIRED by Service + Testcases
    Optional<StudentProfile> findByUserId(Long userId);

    // REQUIRED by Testcases
    boolean existsByEnrollmentId(String enrollmentId);
}
