package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;

public class StudentProfileServiceImpl {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        return repo.save(profile);
    }

    public StudentProfile getByUserId(Long userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("profile not found"));
    }
}
