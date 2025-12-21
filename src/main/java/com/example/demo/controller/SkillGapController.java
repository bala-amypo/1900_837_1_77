package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SkillGapRecordEntity;
import com.example.demo.service.SkillGapService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/gaps")
@Tag(name = "Skill Gaps")
public class SkillGapController {

    private final SkillGapService service;

    public SkillGapController(SkillGapService service) {
        this.service = service;
    }

    @PostMapping("/compute/{studentId}")
    public ResponseEntity<List<SkillGapRecordEntity>> compute(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(service.computeGaps(studentId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<SkillGapRecordEntity>> getByStudent(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(service.getGapsByStudent(studentId));
    }
}
