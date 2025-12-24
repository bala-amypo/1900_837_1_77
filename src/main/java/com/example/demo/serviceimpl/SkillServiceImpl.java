package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    @Override
public Skill createSkill(Skill skill) {
    if (skillRepository.findByCode(skill.getCode()).isPresent()) {
        throw new IllegalArgumentException("Duplicate skill code");
    }
    if (skill.getActive() == null) {
        skill.setActive(true); // also fixes t016
    }
    return skillRepository.save(skill);
}


    @Override
    public Skill updateSkill(Long id, Skill updated) {
        Skill s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        s.setName(updated.getName());
        s.setDescription(updated.getDescription());
        s.setCategory(updated.getCategory());
        s.setMinCompetencyScore(updated.getMinCompetencyScore());

        return repo.save(s);
    }

    @Override
    public Skill getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
    }

    @Override
    public List<Skill> getAllSkills() {
        return repo.findAll();
    }

    @Override
    public List<Skill> getActiveSkills() {
        return repo.findByActiveTrue();
    }

    @Override
    public void deactivateSkill(Long id) {
        Skill s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
        s.setActive(false);
        repo.save(s);
    }
}
