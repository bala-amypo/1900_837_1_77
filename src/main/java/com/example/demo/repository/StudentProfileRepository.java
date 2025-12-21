package com.example.demo.repository;

import com.example.demo.entity.StudentProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentProfileRepository
        extends JpaRepository<StudentProfileEntity, String> {

    Optional<StudentProfileEntity> findByEnrollmentId(String enrollmentId);

    Optional<StudentProfileEntity> findByUser_Email(String email);

    boolean existsByEnrollmentId(String enrollmentId);
}
