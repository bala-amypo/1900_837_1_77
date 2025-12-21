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
    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        return repository.save(profile);
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public StudentProfile getProfileByEnrollmentId(String enrollmentId) {
        return repository.findByEnrollmentId(enrollmentId);
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repository.findAll();
    }
}
