package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SkillEntity;
import com.example.demo.service.SkillService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Skill CRUD")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SkillEntity> create(@RequestBody SkillEntity skill) {
        return ResponseEntity.ok(service.createSkill(skill));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSkillById(id));
    }

    @GetMapping
    public ResponseEntity<List<SkillEntity>> getAll() {
        return ResponseEntity.ok(service.getAllSkills());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillEntity> update(
            @PathVariable Long id,
            @RequestBody SkillEntity skill) {
        return ResponseEntity.ok(service.updateSkill(id, skill));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        service.deactivateSkill(id);
        return ResponseEntity.ok("Skill deactivated");
    }
}
