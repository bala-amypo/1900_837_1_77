package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SkillGapRecordEntity;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.service.SkillGapService;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository repository;

    public SkillGapServiceImpl(SkillGapRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SkillGapRecordEntity> computeGaps(Long studentProfileId) {
        return repository.findByStudentProfileId(studentProfileId);
    }

    @Override
    public List<SkillGapRecordEntity> getGapsByStudent(Long studentProfileId) {
        return repository.findByStudentProfileId(studentProfileId);
    }
}
