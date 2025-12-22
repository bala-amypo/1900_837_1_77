package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile create(StudentProfile profile) {
        profile.preUpdate();
        return repository.save(profile);
    }

    @Override
    public StudentProfile getByUserId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
