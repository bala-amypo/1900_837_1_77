package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;

import java.util.List;

public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository assessmentResultRepository;

    public AssessmentServiceImpl(AssessmentResultRepository assessmentResultRepository) {
        this.assessmentResultRepository = assessmentResultRepository;
    }

    @Override
    public AssessmentResult recordResult(AssessmentResult result) {
        if (result.getScoreObtained() < 0 || result.getScoreObtained() > result.getMaxScore()) {
            throw new IllegalArgumentException("Invalid score");
        }
        return assessmentResultRepository.save(result);
    }

    @Override
    public List<AssessmentResult> getResultsByStudent(Long studentId) {
        return assessmentResultRepository.findByStudentProfileId(studentId);
    }

    @Override
    public AssessmentResult getResultByStudentAndSkill(Long studentId, Long skillId) {
        return assessmentResultRepository
                .findByStudentProfileIdAndSkillId(studentId, skillId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }
}
