package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AssessmentResultEntity;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentResultEntity recordAssessment(AssessmentResultEntity assessment) {
        if (assessment.getScoreObtained() < 0 || assessment.getScoreObtained() > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        return repository.save(assessment);
    }

    @Override
    public List<AssessmentResultEntity> getResultsByStudent(Long studentProfileId) {
        return repository.findByStudentProfileId(studentProfileId);
    }

    @Override
    public List<AssessmentResultEntity> getResultsByStudentAndSkill(
            Long studentProfileId, Long skillId) {
        return repository.findByStudentProfileIdAndSkillId(
                studentProfileId, skillId);
    }
}
