package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.service.StudentProfileService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student CRUD")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<StudentProfileEntity> create(
            @RequestBody StudentProfileEntity student) {
        return ResponseEntity.ok(service.createStudent(student));
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfileEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<StudentProfileEntity>> getAll() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<StudentProfileEntity> update(
            @PathVariable Long id,
            @RequestBody StudentProfileEntity student) {
        return ResponseEntity.ok(service.updateStudent(id, student));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
