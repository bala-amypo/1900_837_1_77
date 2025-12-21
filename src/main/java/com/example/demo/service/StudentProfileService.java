package com.example.demo.service;

import com.example.demo.entity.StudentProfile;

public interface StudentProfileService {

    StudentProfile getByUserId(Long userId);
}
