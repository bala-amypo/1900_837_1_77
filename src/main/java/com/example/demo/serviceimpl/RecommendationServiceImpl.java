package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RecommendationService;

import java.util.ArrayList;
import java.util.List;

public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepository;
    private final SkillGapRecommendationRepository recommendationRepository;
    private final StudentProfileRepository studentRepository;
    private final SkillRepository skillRepository;

    // 🔑 EXACT constructor order
    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepository,
            SkillGapRecommendationRepository recommendationRepository,
            StudentProfileRepository studentRepository,
            SkillRepository skillRepository) {

        this.assessmentRepository = assessmentRepository;
        this.recommendationRepository = recommendationRepository;
        this.studentRepository = studentRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        double target = skill.getMinCompetencyScore();
        double current = assessmentRepository
                .findByStudentProfileIdAndSkillId(studentId, skillId)
                .stream()
                .mapToDouble(a -> a.getScoreObtained())
                .max()
                .orElse(0.0);

        double gap = target - current;

        SkillGapRecommendation rec = new SkillGapRecommendation();
        rec.setSkill(skill);
        rec.setGapScore(gap);
        rec.setGeneratedBy("SYSTEM");

        if (gap >= 20) {
            rec.setPriority("HIGH");
            rec.setRecommendedAction("Immediate training required");
        } else if (gap >= 10) {
            rec.setPriority("MEDIUM");
            rec.setRecommendedAction("Practice recommended");
        } else {
            rec.setPriority("LOW");
            rec.setRecommendedAction("Maintain skill level");
        }

        return recommendationRepository.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        List<SkillGapRecommendation> list = new ArrayList<>();
        for (Skill skill : skillRepository.findByActiveTrue()) {
            list.add(computeRecommendationForStudentSkill(studentId, skill.getId()));
        }
        return list;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository
                .findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}
