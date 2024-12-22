package com.example.school_meal_menu_backend.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchoolMapper {

    List<Map<String, Object>> selectAllSchool();

    List<Map<String, Object>> selectSchoolByPaging(Map<String, Object> params);

    List<Map<String, Object>> selectSchoolByName(String param);

    Integer selectSchoolCount();
}
