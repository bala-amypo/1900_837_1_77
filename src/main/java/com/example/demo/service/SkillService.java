package com.example.demo.service;

import com.example.demo.entity.Skill;
import java.util.List;

public interface SkillService {

    Skill createSkill(Skill skill);

    Skill getById(Long id);

    List<Skill> getAllSkills();

    Skill updateSkill(Long id, Skill skill);  

    void deactivateSkill(Long id);
}
