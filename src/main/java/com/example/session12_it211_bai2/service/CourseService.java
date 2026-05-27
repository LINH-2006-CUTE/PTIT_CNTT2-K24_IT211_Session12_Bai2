package com.example.session12_it211_bai2.service;

import com.example.session12_it211_bai2.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
public class CourseService {
    private final List<Course> courses = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Course> findAll() { return courses; }

    public Course findById(Long id) {
        return courses.stream().filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    log.warn("Không tìm thấy khóa học với ID: {}", id);
                    return null;
                });
    }

    public Course save(Course course) {
        course.setId(counter.getAndIncrement());
        courses.add(course);
        log.info("Khóa học '{}' đã được tạo thành công.", course.getCourseName());
        return course;
    }
}