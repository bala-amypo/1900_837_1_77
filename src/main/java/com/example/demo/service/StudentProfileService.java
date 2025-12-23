package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import java.util.List;

public interface StudentProfileService {

    StudentProfile create(StudentProfile s);
    List<StudentProfile> getAll();
    StudentProfile getById(Long id);
    StudentProfile update(Long id, StudentProfile s);
    void delete(Long id);
}
