package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentResultRepository;
    private final SkillGapRecommendationRepository recommendationRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final SkillRepository skillRepository;

    @Override
    public void computeRecommendationForStudentSkill(Long studentId, Long skillId) {

        List<AssessmentResult> results =
                assessmentResultRepository.findByStudentProfileIdAndSkillId(studentId, skillId);

        if (results.isEmpty()) return;

        double avgScore = results.stream()
                .mapToDouble(AssessmentResult::getScore)
                .average()
                .orElse(0.0);

        double maxScore = results.get(0).getMaxScore();

        if (avgScore < maxScore * 0.6) {
            StudentProfile student = studentProfileRepository.findById(studentId).orElseThrow();
            Skill skill = skillRepository.findById(skillId).orElseThrow();

            SkillGapRecommendation rec = SkillGapRecommendation.builder()
                    .studentProfile(student)
                    .skill(skill)
                    .generatedAt(Instant.now())
                    .build();

            recommendationRepository.save(rec);
        }
    }

    @Override
    public void computeRecommendationsForStudent(Long studentId) {
        List<Skill> skills = skillRepository.findAll();
        for (Skill skill : skills) {
            computeRecommendationForStudentSkill(studentId, skill.getId());
        }
    }
}
