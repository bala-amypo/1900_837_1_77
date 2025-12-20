package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 THIS WAS MISSING OR WRONG
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentResult saveAssessment(AssessmentResult assessmentResult) {
        return repository.save(assessmentResult);
    }

    @Override
    public List<AssessmentResult> getAllAssessments() {
        return repository.findAll();
    }

    @Override
    public AssessmentResult getAssessmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));
    }

    @Override
    public AssessmentResult updateAssessment(Long id, AssessmentResult assessmentResult) {
        AssessmentResult existing = getAssessmentById(id);
        existing.setScore(assessmentResult.getScore());
        existing.setSkill(assessmentResult.getSkill());
        return repository.save(existing);
    }

    @Override
    public void deleteAssessment(Long id) {
        repository.deleteById(id);
    }
}
