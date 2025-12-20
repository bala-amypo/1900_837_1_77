package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import java.util.List;
import java.util.Optional;

public interface StudentProfileService {
    List<StudentProfile> getAllProfiles();
    Optional<StudentProfile> getProfileById(Long id);
    StudentProfile saveProfile(StudentProfile profile);
}
