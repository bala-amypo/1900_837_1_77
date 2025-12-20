package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    @Override
    public AssessmentResult recordAssessment(AssessmentResult result) {
        return repository.save(result);
    }

    @Override
    public List<AssessmentResult> getResultsByStudent(Long studentProfileId) {
        return repository.findByStudentProfileId(studentProfileId);
    }

    @Override
    public AssessmentResult getResultsByStudentAndSkill(Long studentProfileId, Long skillId) {
        return repository
                .findByStudentProfileIdAndSkillId(studentProfileId, skillId)
                .orElse(null);
    }

    @Override
    public Double calculatePercentage(AssessmentResult result) {
        if (result.getMaxScore() == 0) return 0.0;
        return (result.getScoreObtained() * 100.0) / result.getMaxScore();
    }
}
