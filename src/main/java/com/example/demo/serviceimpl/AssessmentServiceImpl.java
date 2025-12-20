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
    public List<AssessmentResult> getResultsByStudentProfile(Long studentProfileId) {
        return repository.findByStudentProfileId(studentProfileId);
    }

    @Override
    public Double calculatePercentage(AssessmentResult result) {
        return (result.getScoreObtained() * 100.0) / result.getMaxScore();
    }
}
