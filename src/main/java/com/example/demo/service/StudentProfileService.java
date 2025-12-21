package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.StudentProfileEntity;

public interface StudentProfileService {

    StudentProfileEntity createStudent(StudentProfileEntity student);

    StudentProfileEntity getStudentById(Long id);

    List<StudentProfileEntity> getAllStudents();

    StudentProfileEntity updateStudent(Long id, StudentProfileEntity student);

    void deleteStudent(Long id);
}
