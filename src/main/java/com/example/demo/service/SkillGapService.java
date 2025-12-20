package com.example.demo.service;

import com.example.demo.entity.SkillGapScore;

import java.util.List;

public interface SkillGapService {

    List<SkillGapScore> computeGapScores(Long studentProfileId);

    List<SkillGapScore> getGapScoresByStudent(Long studentId);
}
