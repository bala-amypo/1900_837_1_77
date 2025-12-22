package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;
import java.util.*;

public interface StudentProfileRepository {
    Optional<StudentProfile> findByEnrollmentId(String enrollmentId);
    Optional<StudentProfile> findByUserId(Long userId);
    boolean existsByEnrollmentId(String enrollmentId);
    Optional<StudentProfile> findById(Long id);
    StudentProfile save(StudentProfile profile);
}
