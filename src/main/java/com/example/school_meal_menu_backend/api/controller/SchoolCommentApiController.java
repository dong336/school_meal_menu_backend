package com.example.school_meal_menu_backend.api.controller;

import com.example.school_meal_menu_backend.service.SchoolCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/school-comment")
@RequiredArgsConstructor
public class SchoolCommentApiController {

    private final SchoolCommentService schoolCommentService;

    @GetMapping("/basic")
    public ResponseEntity<?> selectSchoolCommentBySchool(@RequestParam Map<String, Object> request) {
        String schoolId = (String) request.get("school_id");

        List<Map<String, Object>> results = schoolCommentService.getCommentBySchool(schoolId);

        return new ResponseEntity<>(
                results,
                HttpStatus.OK
        );
    }

    @PostMapping("/basic")
    public ResponseEntity<?> insertCommentOne(@RequestBody Map<String, Object> request) {
        int id = (int) request.get("school_id");
        String schoolName = (String) request.get("school_name");
        String comment = (String) request.get("comment");
        String createdByAnonymous = (String) request.get("created_by_anonymous");
        String createdBy= (String) request.get("created_by");

        schoolCommentService.insertCommentOne(id, schoolName, comment, createdByAnonymous, createdBy);

        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/basic")
    public ResponseEntity<?> deleteCommentOne(@RequestBody Map<String, Object> request) {
        int id = (int) request.get("id");

        schoolCommentService.deleteCommentOne(id);

        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }

    @PutMapping("/basic")
    public ResponseEntity<?> updateCommentOne(@RequestBody Map<String, Object> request) {
        int id = (int) request.get("id");
        String comment = (String) request.get("comment");

        schoolCommentService.updateCommentOne(id, comment);

        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }
}
