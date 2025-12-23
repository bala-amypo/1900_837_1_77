package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile create(StudentProfile s) {
        return repo.save(s);
    }

    @Override
    public List<StudentProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public StudentProfile getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public StudentProfile update(Long id, StudentProfile s) {
        s.setId(id);
        return repo.save(s);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
