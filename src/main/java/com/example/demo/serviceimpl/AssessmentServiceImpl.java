package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repo;

    public AssessmentServiceImpl(AssessmentResultRepository repo) {
        this.repo = repo;
    }

    @Override
    public AssessmentResult create(AssessmentResult a) {
        return repo.save(a);
    }

    @Override
    public List<AssessmentResult> getAll() {
        return repo.findAll();
    }

    @Override
    public AssessmentResult getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public AssessmentResult update(Long id, AssessmentResult a) {
        a.setId(id);
        return repo.save(a);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
