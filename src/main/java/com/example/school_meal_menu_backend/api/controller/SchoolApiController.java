package com.example.school_meal_menu_backend.api.controller;

import com.example.school_meal_menu_backend.mapper.SchoolMapper;
import com.example.school_meal_menu_backend.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/school")
@RequiredArgsConstructor
public class SchoolApiController {

    private final SchoolService schoolService;

    @GetMapping("/search")
    public ResponseEntity<?> selectSchoolByName(@RequestParam Map<String, Object> request) {
        log.debug("req: {}", request);

        String schoolName = (String) request.get("school_name");

        List<Map<String, Object>> results = schoolService.getSchoolsByName(schoolName);

        return new ResponseEntity<>(
                results,
                HttpStatus.OK
        );
    }

    @GetMapping("/menu")
    public ResponseEntity<?> bringMealFromNeis(@RequestParam Map<String, Object> request) {
        log.debug("req: {}", request);

        String id = (String) request.get("id");
        String date = (String) request.get("date");

        Map<String, Object> result = schoolService.getTodaySchoolMenu(id, date);

        return new ResponseEntity<>(
                result,
                HttpStatus.OK
        );
    }
}
