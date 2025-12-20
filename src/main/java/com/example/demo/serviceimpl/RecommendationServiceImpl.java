package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecordRepository gapRepository;
    private final SkillGapRecommendationRepository recommendationRepository;
    private final StudentProfileRepository studentRepository;
    private final SkillRepository skillRepository;

    public RecommendationServiceImpl(SkillGapRecordRepository gapRepository,
                                     SkillGapRecommendationRepository recommendationRepository,
                                     StudentProfileRepository studentRepository,
                                     SkillRepository skillRepository) {
        this.gapRepository = gapRepository;
        this.recommendationRepository = recommendationRepository;
        this.studentRepository = studentRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {
        SkillGapRecord gap = gapRepository.findByStudentProfileId(studentId).stream()
                .filter(r -> r.getSkill().getId().equals(skillId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("SkillGapRecord not found"));

        SkillGapRecommendation rec = new SkillGapRecommendation();
        rec.setStudentProfile(gap.getStudentProfile());
        rec.setSkill(gap.getSkill());
        rec.setGapScore(gap.getGapScore());
        rec.setGeneratedBy("SYSTEM");

        // Priority
        if (gap.getGapScore() >= 20) rec.setPriority("HIGH");
        else if (gap.getGapScore() >= 10) rec.setPriority("MEDIUM");
        else rec.setPriority("LOW");

        rec.setRecommendedAction("Practice and improve " + gap.getSkill().getSkillName());
        recommendationRepository.save(rec);
        return rec;
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {
        List<SkillGapRecord> gaps = gapRepository.findByStudentProfileId(studentId);
        gaps.forEach(r -> computeRecommendationForStudentSkill(studentId, r.getSkill().getId()));
        return recommendationRepository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}
