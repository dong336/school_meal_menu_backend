package com.example.school_meal_menu_backend.api.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class NeisClient {

    private final RestTemplate restTemplate;
    private static final String url = "https://open.neis.go.kr/hub/mealServiceDietInfo?Type=json&pIndex=1&pSize=1&ATPT_OFCDC_SC_CODE=B10&SD_SCHUL_CODE=7010268&KEY=419b7095657244768fc2fa5f6b4c4ab4&MLSV_YMD=20241223";

    public Map<String, Object> fetchJsonAsMap() {
        try {
            ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);

            return (Map<String, Object>) responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            e.printStackTrace();

            return Map.of();
        }
    }
}
