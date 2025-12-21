package com.example.demo.service;

import com.example.demo.entity.StudentProfileEntity;

import java.util.List;

public interface StudentProfileService {

    StudentProfileEntity createProfile(StudentProfileEntity profile);

    StudentProfileEntity getProfileByEnrollmentId(String enrollmentId);

    List<StudentProfileEntity> getAllProfiles();
}
