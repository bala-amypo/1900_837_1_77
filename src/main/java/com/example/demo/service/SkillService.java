package com.example.demo.service;

import com.example.demo.entity.Skill;

import java.util.List;

public interface SkillService {

    Skill createSkill(Skill skill);

    List<Skill> getAllSkills();

    List<Skill> getActiveSkills();

    Skill getById(Long id);

    Skill updateSkill(Long id, Skill skill);

    void deactivateSkill(Long id);
}
