package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SkillEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillEntity createSkill(SkillEntity skill) {
        return repository.save(skill);
    }

    @Override
    public SkillEntity getSkillById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Skill not found"));
    }

    @Override
    public List<SkillEntity> getAllSkills() {
        return repository.findAll();
    }

    @Override
    public List<SkillEntity> getActiveSkills() {
        return repository.findByActiveTrue();
    }

    @Override
    public SkillEntity updateSkill(Long id, SkillEntity skill) {
        SkillEntity existing = getSkillById(id);
        existing.setSkillName(skill.getSkillName());
        existing.setCategory(skill.getCategory());
        existing.setDescription(skill.getDescription());
        return repository.save(existing);
    }

    @Override
    public void deactivateSkill(Long id) {
        SkillEntity skill = getSkillById(id);
        skill.setActive(false);
        repository.save(skill);
    }
}
