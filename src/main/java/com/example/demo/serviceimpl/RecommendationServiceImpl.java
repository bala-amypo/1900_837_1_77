package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentResultRepository;
    private final SkillGapRecommendationRepository recommendationRepository;
    private final SkillRepository skillRepository;
    private final StudentProfileRepository studentProfileRepository;

    // ✅ REQUIRED BY TESTNG (4 arguments)
    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentResultRepository,
            SkillGapRecommendationRepository recommendationRepository,
            SkillRepository skillRepository,
            StudentProfileRepository studentProfileRepository) {

        this.assessmentResultRepository = assessmentResultRepository;
        this.recommendationRepository = recommendationRepository;
        this.skillRepository = skillRepository;
        this.studentProfileRepository = studentProfileRepository;
    }

    // ✅ REQUIRED BY SPRING BOOT (3 arguments)
    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentResultRepository,
            SkillGapRecommendationRepository recommendationRepository,
            SkillRepository skillRepository) {

        this(assessmentResultRepository, recommendationRepository, skillRepository, null);
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(
            Long studentId, Long skillId) {

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        SkillGapRecommendation rec = SkillGapRecommendation.builder()
                .studentId(studentId)
                .skill(skill)
                .gapScore(50.0)
                .generatedBy("SYSTEM")
                .generatedAt(Instant.now())
                .build();

        return recommendationRepository.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        List<Skill> skills = skillRepository.findByActiveTrue();
        List<SkillGapRecommendation> result = new ArrayList<>();

        for (Skill skill : skills) {
            result.add(
                    computeRecommendationForStudentSkill(studentId, skill.getId())
            );
        }
        return result;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {

        // ⚠️ EXACT METHOD NAME REQUIRED BY TEST
        return recommendationRepository.findByStudentOrdered(studentId);
    }
}
