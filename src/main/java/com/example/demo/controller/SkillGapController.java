package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecordEntity;
import com.example.demo.service.SkillGapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gaps")
public class SkillGapController {

    private final SkillGapService service;

    public SkillGapController(SkillGapService service) {
        this.service = service;
    }

    @PostMapping("/student/{enrollmentId}")
    public ResponseEntity<List<SkillGapRecordEntity>> computeGaps(
            @PathVariable String enrollmentId) {
        return ResponseEntity.ok(
                service.computeGapScores(enrollmentId));
    }

    @GetMapping("/student/{enrollmentId}")
    public ResponseEntity<List<SkillGapRecordEntity>> getGaps(
            @PathVariable String enrollmentId) {
        return ResponseEntity.ok(
                service.getGapScoresByStudent(enrollmentId));
    }
}
