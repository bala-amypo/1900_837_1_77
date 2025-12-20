package com.example.demo.controller;

import com.example.demo.entity.SkillGapScore;
import com.example.demo.service.SkillGapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gaps")
public class SkillGapController {

    private final SkillGapService skillGapService;

    public SkillGapController(SkillGapService skillGapService) {
        this.skillGapService = skillGapService;
    }

    @PostMapping("/student/{studentId}")
    public ResponseEntity<List<SkillGapScore>> compute(
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(
                skillGapService.computeGapScores(studentId)
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<SkillGapScore>> get(
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(
                skillGapService.getGapScoresByStudent(studentId)
        );
    }
}
