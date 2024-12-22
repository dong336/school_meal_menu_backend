package com.example.school_meal_menu_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School {

    private int id;
    private String atptOfcdcScCode;  // 시도교육청코드
    private String sdSchulCode;  // 행정표준코드
    private String schoolName;
    private String address;
    private String schoolArea;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
