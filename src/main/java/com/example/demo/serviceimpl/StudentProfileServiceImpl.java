package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfileEntity;
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
    public StudentProfileEntity createProfile(StudentProfileEntity profile) {

        if (repository.existsByEnrollmentId(profile.getEnrollmentId())) {
            throw new IllegalArgumentException("Email already exists");
        }

        return repository.save(profile);
    }

    @Override
    public StudentProfileEntity getProfileByEnrollmentId(String enrollmentId) {

        return repository.findByEnrollmentId(enrollmentId)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }

    @Override
    public List<StudentProfileEntity> getAllProfiles() {
        return repository.findAll();
    }
}
