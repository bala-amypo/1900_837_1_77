package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.SkillEntity;

public interface SkillService {

    SkillEntity createSkill(SkillEntity skill);

    SkillEntity getSkillById(Long id);

    List<SkillEntity> getAllSkills();

    List<SkillEntity> getActiveSkills();

    SkillEntity updateSkill(Long id, SkillEntity skill);

    void deactivateSkill(Long id);
}
