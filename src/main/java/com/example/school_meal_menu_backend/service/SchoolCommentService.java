package com.example.school_meal_menu_backend.service;

import com.example.school_meal_menu_backend.mapper.SchoolCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SchoolCommentService {

    private final SchoolCommentMapper schoolCommentMapper;

    public List<Map<String, Object>> getCommentBySchool(String schoolId) {
        int schoolIdParsed = Integer.parseInt(schoolId);

        List<Map<String, Object>> dataList = schoolCommentMapper.selectCommentBySchool(schoolIdParsed);

        return dataList;
    }

    public void insertCommentOne(int schoolId, String schoolName, String comment, String createdByAnonymous, String createdBy) {
        Map<String, Object> params = Map.of(
                "schoolId", schoolId,
                "schoolName", schoolName,
                "comment", comment,
                "createdByAnonymous", createdByAnonymous,
                "createdBy", createdBy
        );

        schoolCommentMapper.insertCommentOne(params);
    }

    public void deleteCommentOne(int id) {
        schoolCommentMapper.deleteCommentOne(id);
    }

    public void updateCommentOne(int id, String comment) {
        Map<String, Object> params = Map.of(
                "id", id,
                "comment", comment
        );

        schoolCommentMapper.updateCommentOne(params);
    }
}
