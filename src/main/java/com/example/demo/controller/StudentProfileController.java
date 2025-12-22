package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    // ✅ CREATE or UPDATE profile
    @PostMapping
    public StudentProfile createProfile(@RequestBody StudentProfile profile) {
        return service.createOrUpdateProfile(profile);
    }

    // ✅ GET profile by userId
    @GetMapping("/{userId}")
    public StudentProfile getByUserId(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    // ✅ GET all profiles
    @GetMapping
    public List<StudentProfile> getAllProfiles() {
        return service.getAll();
    }
}
