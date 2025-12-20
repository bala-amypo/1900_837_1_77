package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
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
        return repository.save(profile);
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public StudentProfile getProfileByEnrollmentId(String enrollmentId) {
        return repository.findByEnrollmentId(enrollmentId)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repository.findAll();
    }
}
