package com.example.school_meal_menu_backend.api.controller;

import com.example.school_meal_menu_backend.mapper.SchoolMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping
@RestController
@RequiredArgsConstructor
public class TestController {

    private static final Gson gson = new Gson();
    private final SchoolMapper schoolMapper;

    @GetMapping("/test")
    public ResponseEntity<?> testMethod() {

//        Map<String, Object> params = Map.of(
//                "pageNum", 0,
//                "count", 50
//        );
//        List<Map<String, Object>> schools = schoolMapper.selectSchoolByPaging(params);

        //log.info("DATA: {}", schoolMapper.selectAllSchool());

        return new ResponseEntity<>(
                Map.of("message", "success"),
                HttpStatus.OK
        );
    }

    @GetMapping("/all-school")
    public ResponseEntity<?> getAllSchool() {
        List<Map<String, Object>> data = schoolMapper.selectAllSchool();

        return new ResponseEntity<>(
                data,
                HttpStatus.OK
        );
    }
}
