package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;
import java.util.*;

public interface StudentProfileRepository {
    Optional<StudentProfile> findByUserId(Long userId);
    Optional<StudentProfile> findById(Long id);
    boolean existsByEnrollmentId(String enrollmentId);
    StudentProfile save(StudentProfile profile);
}
