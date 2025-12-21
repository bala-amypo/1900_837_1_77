package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.SkillGapRecordEntity;

public interface SkillGapService {

    List<SkillGapRecordEntity> computeGaps(Long studentProfileId);

    List<SkillGapRecordEntity> getGapsByStudent(Long studentProfileId);
}
