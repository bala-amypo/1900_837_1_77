package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillRepository skillRepo;
    private final SkillGapRecordRepository gapRepo;

    public SkillGapServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillRepository skillRepo,
            SkillGapRecordRepository gapRepo
    ) {
        this.assessmentRepo = assessmentRepo;
        this.skillRepo = skillRepo;
        this.gapRepo = gapRepo;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentId) {
        return gapRepo.findByStudentProfileId(studentId);
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentId) {
        return gapRepo.findByStudentProfileId(studentId);
    }
}
