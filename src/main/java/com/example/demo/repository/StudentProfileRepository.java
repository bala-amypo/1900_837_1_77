package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StudentProfileEntity;

public interface StudentProfileRepository
        extends JpaRepository<StudentProfileEntity, Long> {

    boolean existsByEnrollmentId(String enrollmentId);

    Optional<StudentProfileEntity> findByEnrollmentId(String enrollmentId);

    Optional<StudentProfileEntity> findByUserId(Long userId);
}
