package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfileEntity createStudent(StudentProfileEntity student) {
        if (repository.existsByEnrollmentId(student.getEnrollmentId())) {
            throw new IllegalArgumentException("Enrollment ID already exists");
        }
        return repository.save(student);
    }

    @Override
    public StudentProfileEntity getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfileEntity> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public StudentProfileEntity updateStudent(Long id, StudentProfileEntity student) {
        StudentProfileEntity existing = getStudentById(id);

        existing.setEnrollmentId(student.getEnrollmentId());
        existing.setCohort(student.getCohort());
        existing.setYearLevel(student.getYearLevel());
        existing.setActive(student.getActive());

        return repository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.delete(getStudentById(id));
    }
}
