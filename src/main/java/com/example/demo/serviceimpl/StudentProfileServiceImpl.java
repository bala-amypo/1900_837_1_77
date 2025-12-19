package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    public StudentProfile createProfile(StudentProfile profile) {
        if (repository.existsByEnrollmentId(profile.getEnrollmentId())) {
            throw new RuntimeException("Enrollment ID already exists");
        }
        return repository.save(profile);
    }
}
