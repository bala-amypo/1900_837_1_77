package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile create(@RequestBody StudentProfile student) {
        return service.create(student);
    }

    @GetMapping
    public List<StudentProfile> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public StudentProfile update(@PathVariable Long id, @RequestBody StudentProfile student) {
        return service.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
