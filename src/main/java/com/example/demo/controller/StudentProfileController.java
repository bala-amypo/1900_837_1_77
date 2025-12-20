package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    @Autowired
    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentProfileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public Optional<StudentProfile> getStudent(@PathVariable Long id) {
        return studentProfileService.getProfileById(id);
    }

    @PostMapping
    public StudentProfile addStudent(@RequestBody StudentProfile profile) {
        return studentProfileService.saveProfile(profile);
    }
}
