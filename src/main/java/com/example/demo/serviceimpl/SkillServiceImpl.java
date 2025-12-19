package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl {

    public String getSkillSummary(Skill skill) {
        return "Skill: " + skill.getSkillName() +
               ", Minimum Score: " + skill.getMinCompetencyScore();
    }
}
