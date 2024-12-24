package com.example.school_meal_menu_backend.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchoolCommentMapper {

    List<Map<String, Object>> selectCommentBySchool(int schoolId);

    void insertCommentOne(Map<String, Object> params);

    void updateCommentOne(Map<String,Object> params);

    void deleteCommentOne(int id);
}
