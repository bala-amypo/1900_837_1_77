package com.example.demo.serviceimpl;

import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final AssessmentResultRepository assessmentRepository;

    public SkillGapServiceImpl(AssessmentResultRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public String analyzeSkillGap(Long studentProfileId) {
        return "Skill gap analysis for student " + studentProfileId;
    }
}
