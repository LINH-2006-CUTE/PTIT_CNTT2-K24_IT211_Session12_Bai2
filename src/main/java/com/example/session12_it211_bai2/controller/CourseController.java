package com.example.session12_it211_bai2.controller;

import com.example.session12_it211_bai2.model.Course;
import com.example.session12_it211_bai2.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired private CourseService service;
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        log.info("Request: POST /api/courses - Đang thêm mới: {}", course.getCourseName());
        return new ResponseEntity<>(service.save(course), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Course> getAll() {
        log.info("Request: GET /api/courses");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        log.info("Request: GET /api/courses/{}", id);
        try {
            Course c = service.findById(id);
            return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Lỗi hệ thống: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}