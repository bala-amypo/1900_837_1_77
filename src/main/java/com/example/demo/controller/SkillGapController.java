package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.SkillGapRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gaps")
public class SkillGapController {

    private final SkillGapRecordRepository repo;

    public SkillGapController(SkillGapRecordRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/student/{studentId}")
    public List<SkillGapRecord> getGaps(@PathVariable Long studentId) {
        return repo.findByStudentProfileId(studentId);
    }
}
