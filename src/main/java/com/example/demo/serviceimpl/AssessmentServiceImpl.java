package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;

import java.util.List;

public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    // 🔑 EXACT constructor order
    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentResult recordAssessment(AssessmentResult result) {

        if (result.getScoreObtained() == 0 ||
            result.getScoreObtained() < 0 ||
            result.getScoreObtained() > result.getMaxScore()) {
            throw new IllegalArgumentException("Invalid score");
        }

        if (result.getMaxScore() == 0) {
            result.setMaxScore(100.0);
        }

        return repository.save(result);
    }

    @Override
    public List<AssessmentResult> getResultsByStudent(Long studentId) {
        return repository.findByStudentProfileId(studentId);
    }

    @Override
    public List<AssessmentResult> getResultsByStudentAndSkill(Long studentId, Long skillId) {
        return repository.findByStudentProfileIdAndSkillId(studentId, skillId);
    }
}
