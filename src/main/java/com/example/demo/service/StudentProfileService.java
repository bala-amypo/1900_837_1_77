package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.StudentProfile;

public interface StudentProfileService {

    StudentProfile create(StudentProfile profile);

    List<StudentProfile> getAll();
}
