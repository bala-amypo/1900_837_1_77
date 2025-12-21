package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Override
    public StudentProfile getByUserId(Long userId) {
        return null;
    }
}
