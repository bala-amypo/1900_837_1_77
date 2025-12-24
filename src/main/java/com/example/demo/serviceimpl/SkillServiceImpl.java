package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

import java.util.List;

public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill createSkill(Skill skill) {
        if (skillRepository.findByCode(skill.getCode()).isPresent()) {
            throw new IllegalArgumentException("Skill code must be unique");
        }

        return skillRepository.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill updated) {
        Skill existing = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        existing.setName(updated.getName());
        existing.setCategory(updated.getCategory());
        existing.setDescription(updated.getDescription());
        existing.setMinCompetencyScore(updated.getMinCompetencyScore());

        return skillRepository.save(existing);
    }

    @Override
    public Skill getById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public List<Skill> getActiveSkills() {
        return skillRepository.findByActiveTrue();
    }

    @Override
    public void deactivateSkill(Long id) {
        Skill s = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
        s.setActive(false);
        skillRepository.save(s);
    }
}
