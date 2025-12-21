package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public StudentProfile getByUserId(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}
