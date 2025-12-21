package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository recommendationRepository;

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository.findByStudentProfileId(studentId);
    }
}
