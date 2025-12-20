package com.example.demo.controller;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public Skill create(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill skill) {
        return skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        skillService.deactivateSkill(id);
    }

    @GetMapping("/{id}")
    public Skill get(@PathVariable Long id) {
        return skillService.getById(id);
    }

    @GetMapping
    public List<Skill> all() {
        return skillService.getAllSkills();
    }

    @GetMapping("/active")
    public List<Skill> active() {
        return skillService.getActiveSkills();
    }
}
