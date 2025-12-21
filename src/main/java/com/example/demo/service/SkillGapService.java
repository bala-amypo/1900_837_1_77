package com.example.demo.service;

import com.example.demo.entity.SkillGapRecordEntity;

import java.util.List;

public interface SkillGapService {

    List<SkillGapRecordEntity> computeGapScores(String enrollmentId);

    List<SkillGapRecordEntity> getGapScoresByStudent(String enrollmentId);
}
