package com.example.demo.service;

import com.example.demo.entity.Skill;
import java.util.List;

public interface SkillService {
    List<Skill> getAllSkills();
    Skill getSkillById(Long id);
    Skill createSkill(Skill skill);
}
