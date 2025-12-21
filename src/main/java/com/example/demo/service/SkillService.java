package com.example.demo.service;

import com.example.demo.entity.SkillEntity;

import java.util.List;

public interface SkillService {

    SkillEntity createSkill(SkillEntity skill);

    SkillEntity updateSkill(String skillName, SkillEntity skill);

    SkillEntity getSkillByName(String skillName);

    List<SkillEntity> getAllSkills();

    void deactivateSkill(String skillName);
}
