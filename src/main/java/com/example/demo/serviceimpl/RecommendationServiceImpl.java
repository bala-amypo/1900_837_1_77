package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecordRepository gapRepo;
    private final SkillGapRecommendationRepository recRepo;
    private final StudentProfileRepository studentRepo;

    public RecommendationServiceImpl(
            SkillGapRecordRepository gapRepo,
            SkillGapRecommendationRepository recRepo,
            StudentProfileRepository studentRepo
    ) {
        this.gapRepo = gapRepo;
        this.recRepo = recRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public List<SkillGapRecommendationEntity> generateRecommendations(String enrollmentId) {

        StudentProfileEntity student =
                studentRepo.findByEnrollmentId(enrollmentId)
                        .orElseThrow(() -> new IllegalArgumentException("Not Found"));

        List<SkillGapRecordEntity> gaps = gapRepo.findByStudentProfile(student);
        List<SkillGapRecommendationEntity> list = new ArrayList<>();

        for (SkillGapRecordEntity gap : gaps) {

            SkillGapRecommendationEntity rec = new SkillGapRecommendationEntity();
            rec.setStudentProfile(student);
            rec.setSkill(gap.getSkill());
            rec.setGapScore(gap.getGapScore());
            rec.setGeneratedBy("SYSTEM");

            if (gap.getGapScore() >= 20) {
                rec.setPriority("HIGH");
            } else if (gap.getGapScore() >= 10) {
                rec.setPriority("MEDIUM");
            } else {
                rec.setPriority("LOW");
            }

            rec.setRecommendedAction("Improve " + gap.getSkill().getSkillName());
            list.add(recRepo.save(rec));
        }

        return list;
    }

    @Override
    public List<SkillGapRecommendationEntity> getRecommendationsByStudent(String enrollmentId) {

        StudentProfileEntity student =
                studentRepo.findByEnrollmentId(enrollmentId)
                        .orElseThrow(() -> new IllegalArgumentException("Not Found"));

        return recRepo.findByStudentProfileOrderByGeneratedAtDesc(student);
    }
}
