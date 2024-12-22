package com.example.school_meal_menu_backend.service;

import com.example.school_meal_menu_backend.api.client.NeisClient;
import com.example.school_meal_menu_backend.mapper.SchoolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final NeisClient neisClient;

    public List<Map<String, Object>> getSchoolsByName(String schoolName) {
        List<Map<String, Object>> dataList = schoolMapper.selectSchoolByName(schoolName);

        return dataList.stream().map(data -> Map.of(
                "id", data.get("id"),
                "address", data.get("address"),
                "school_name", data.get("school_name")
            )
        ).toList();
    }

    public Map<String, Object> getTodaySchoolMenu(String schoolName) {

        Map<String, Object> rawData = neisClient.fetchJsonAsMap();

        return null;
    }
}
