package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResultEntity;
import com.example.demo.entity.SkillEntity;
import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.AssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository assessmentRepo;
    private final StudentProfileRepository studentRepo;
    private final SkillRepository skillRepo;

    public AssessmentServiceImpl(
            AssessmentResultRepository assessmentRepo,
            StudentProfileRepository studentRepo,
            SkillRepository skillRepo
    ) {
        this.assessmentRepo = assessmentRepo;
        this.studentRepo = studentRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public AssessmentResultEntity recordResult(AssessmentResultEntity result) {

        if (result.getScoreObtained() < 0 ||
                result.getScoreObtained() > result.getMaxScore()) {
            throw new IllegalArgumentException("Invalid score");
        }

        return assessmentRepo.save(result);
    }

    @Override
    public List<AssessmentResultEntity> getResultsByStudent(String enrollmentId) {

        StudentProfileEntity student =
                studentRepo.findByEnrollmentId(enrollmentId)
                        .orElseThrow(() -> new IllegalArgumentException("Not Found"));

        return assessmentRepo.findByStudentProfile(student);
    }

    @Override
    public List<AssessmentResultEntity> getResultByStudentAndSkill(
            String enrollmentId,
            String skillName
    ) {
        StudentProfileEntity student =
                studentRepo.findByEnrollmentId(enrollmentId)
                        .orElseThrow(() -> new IllegalArgumentException("Not Found"));

        SkillEntity skill =
                skillRepo.findBySkillName(skillName)
                        .orElseThrow(() -> new IllegalArgumentException("Not Found"));

        return assessmentRepo.findByStudentProfileAndSkill(student, skill);
    }
}
