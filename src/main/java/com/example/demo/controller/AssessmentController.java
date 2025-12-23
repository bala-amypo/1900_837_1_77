package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public AssessmentResult create(@RequestBody AssessmentResult result) {
        return service.create(result);
    }

    @GetMapping
    public List<AssessmentResult> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AssessmentResult getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public AssessmentResult update(@PathVariable Long id, @RequestBody AssessmentResult result) {
        return service.update(id, result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
