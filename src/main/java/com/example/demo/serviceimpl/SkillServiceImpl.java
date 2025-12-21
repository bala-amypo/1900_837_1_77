package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillEntity;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillEntity createSkill(SkillEntity skill) {

        if (repository.findBySkillName(skill.getSkillName()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (skill.getMinCompetencyScore() < 0 || skill.getMinCompetencyScore() > 100) {
            throw new IllegalArgumentException("Invalid score");
        }

        return repository.save(skill);
    }

    @Override
    public SkillEntity updateSkill(String skillName, SkillEntity skill) {

        SkillEntity existing = getSkillByName(skillName);

        existing.setCategory(skill.getCategory());
        existing.setDescription(skill.getDescription());
        existing.setMinCompetencyScore(skill.getMinCompetencyScore());

        return repository.save(existing);
    }

    @Override
    public SkillEntity getSkillByName(String skillName) {

        return repository.findBySkillName(skillName)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }

    @Override
    public List<SkillEntity> getAllSkills() {
        return repository.findAll();
    }

    @Override
    public void deactivateSkill(String skillName) {

        SkillEntity skill = getSkillByName(skillName);
        skill.setActive(false);
        repository.save(skill);
    }
}
