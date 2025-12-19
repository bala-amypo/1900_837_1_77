package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssessmentServiceImpl {

    private final AssessmentResultRepository repository;

    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    public AssessmentResult getAssessment(Long profileId, Long skillId) {
        Optional<AssessmentResult> result =
                repository.findByStudentProfileIdAndSkillId(profileId, skillId);

        return result.orElseThrow(() ->
                new RuntimeException("Assessment not found"));
    }
}
