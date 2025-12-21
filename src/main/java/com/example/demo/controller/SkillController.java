package com.example.demo.controller;

import com.example.demo.entity.SkillEntity;
import com.example.demo.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SkillEntity> create(
            @RequestBody SkillEntity skill) {
        return ResponseEntity.ok(service.createSkill(skill));
    }

    @PutMapping("/{skillName}")
    public ResponseEntity<SkillEntity> update(
            @PathVariable String skillName,
            @RequestBody SkillEntity skill) {
        return ResponseEntity.ok(
                service.updateSkill(skillName, skill));
    }

    @GetMapping("/{skillName}")
    public ResponseEntity<SkillEntity> get(
            @PathVariable String skillName) {
        return ResponseEntity.ok(service.getSkillByName(skillName));
    }

    @GetMapping
    public ResponseEntity<List<SkillEntity>> getAll() {
        return ResponseEntity.ok(service.getAllSkills());
    }

    @PutMapping("/{skillName}/deactivate")
    public ResponseEntity<Void> deactivate(
            @PathVariable String skillName) {
        service.deactivateSkill(skillName);
        return ResponseEntity.ok().build();
    }
}
