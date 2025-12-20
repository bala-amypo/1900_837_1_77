package com.example.demo.controller;

import com.example.demo.service.SkillGapService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill-gap")
public class SkillGapController {

    private final SkillGapService skillGapService;

    public SkillGapController(SkillGapService skillGapService) {
        this.skillGapService = skillGapService;
    }

    @GetMapping("/{studentId}")
    public String analyzeSkillGap(@PathVariable Long studentId) {
        return skillGapService.analyzeSkillGap(studentId);
    }
}
