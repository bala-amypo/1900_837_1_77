package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createOrUpdateProfile(StudentProfile profile) {

        if (profile.getEnrollmentId() != null &&
            repository.existsByEnrollmentId(profile.getEnrollmentId())) {
            throw new IllegalArgumentException("Enrollment ID already exists");
        }

        profile.preUpdate();
        return repository.save(profile);
    }

    @Override
    public StudentProfile getByUserId(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));
    }

    @Override
    public List<StudentProfile> getAll() {
        return repository.findAll();
    }
}
