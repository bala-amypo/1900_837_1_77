package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentResult recordResult(AssessmentResult result) {
        if (result.getScoreObtained() < 0 || result.getScoreObtained() > result.getMaxScore()) {
            throw new IllegalArgumentException("Score must be between 0 and " + result.getMaxScore());
        }
        return repository.save(result);
    }

    @Override
    public List<AssessmentResult> getResultsByStudent(Long studentId) {
        return repository.findByStudentProfileId(studentId);
    }

    @Override
    public List<AssessmentResult> getResultByStudentAndSkill(Long studentId, Long skillId) {
        return repository.findByStudentProfileIdAndSkillId(studentId, skillId);
    }
}
