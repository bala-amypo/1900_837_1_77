package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createProfile(
            @RequestBody StudentProfile profile) {
        return ResponseEntity.ok(service.createOrUpdateProfile(profile));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<StudentProfile> getByUserId(
            @PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }
}
