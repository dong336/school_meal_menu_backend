package com.example.school_meal_menu_backend.service;

import com.example.school_meal_menu_backend.api.client.NeisClient;
import com.example.school_meal_menu_backend.dto.neis.NeisResponse;
import com.example.school_meal_menu_backend.mapper.SchoolMapper;
import com.example.school_meal_menu_backend.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final NeisClient neisClient;

    public List<Map<String, Object>> getSchoolsByName(String schoolName) {
        List<Map<String, Object>> dataList = schoolMapper.selectSchoolByName(schoolName);

        return dataList;
    }

    public Map<String, Object> getTodaySchoolMenu(String id, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsed = LocalDate.parse(date, formatter);

        YearMonth yearMonth = YearMonth.from(parsed);
        LocalDate firstDayOfMonth = yearMonth.atDay(1);
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();

        Map<String, Object> data = schoolMapper.selectSchoolOne(Integer.parseInt(id));

        String atptOfcdcScCode = (String) data.get("atpt_ofcdc_sc_code");
        String sdSchulCode = (String) data.get("sd_schul_code");

        String jsonBody = neisClient
                .getMealsForDateAndSchool(
                        atptOfcdcScCode,
                        sdSchulCode,
                        DateUtil.convertToStrFromDate(firstDayOfMonth),
                        DateUtil.convertToStrFromDate(lastDayOfMonth)
                );

        log.info("dishs: {}", jsonBody);

        return Map.of("data", jsonBody);
    }
}
