package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createProfile(@RequestBody StudentProfile profile) {
        return ResponseEntity.ok(studentProfileService.createProfile(profile));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentProfileService.getProfileById(id));
    }

    @GetMapping("/enrollment/{enrollmentId}")
    public ResponseEntity<StudentProfile> getByEnrollment(@PathVariable String enrollmentId) {
        return ResponseEntity.ok(
                studentProfileService.getProfileByEnrollmentId(enrollmentId)
        );
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAll() {
        return ResponseEntity.ok(studentProfileService.getAllProfiles());
    }
}
