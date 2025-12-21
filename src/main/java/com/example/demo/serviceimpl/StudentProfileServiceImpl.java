package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        return studentProfileRepository.save(profile);
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentProfile not found"));
    }

    @Override
    public StudentProfile getProfileByEnrollmentId(String enrollmentId) {
        return studentProfileRepository.findByEnrollmentId(enrollmentId)
                .orElseThrow(() -> new RuntimeException("StudentProfile not found"));
    }
}
