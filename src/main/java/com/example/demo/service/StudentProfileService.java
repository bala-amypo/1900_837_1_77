package com.example.demo.service;

import com.example.demo.entity.StudentProfile;

public interface StudentProfileService {

    StudentProfile create(StudentProfile profile);

    StudentProfile getByUserId(Long id);
}
