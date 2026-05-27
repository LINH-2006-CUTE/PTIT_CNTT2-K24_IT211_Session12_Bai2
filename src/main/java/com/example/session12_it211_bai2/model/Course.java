package com.example.session12_it211_bai2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long id;
    private String courseName;
    private String instructor;
    private Integer durationHours;
    private Double fee;
}