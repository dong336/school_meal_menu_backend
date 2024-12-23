package com.example.school_meal_menu_backend.api.client;

import com.example.school_meal_menu_backend.dto.neis.NeisResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class NeisClient {

    private final RestTemplate restTemplate;
    private static final String domain = "https://open.neis.go.kr/hub/mealServiceDietInfo";
    private static final String key = "419b7095657244768fc2fa5f6b4c4ab4";

    public String getMealsForDateAndSchool(
            String atptOfcdcScCode,
            String sdSchulCode,
            String mlsvFromYmd,
            String mlsvToYmd) {
        String responseBody = "";
        try {
            String uri = UriComponentsBuilder.fromUriString("https://open.neis.go.kr/hub/mealServiceDietInfo")
                    .queryParam("Type", "json")
                    .queryParam("pIndex", 1)
                    .queryParam("pSize", 30)
                    .queryParam("ATPT_OFCDC_SC_CODE", atptOfcdcScCode)
                    .queryParam("SD_SCHUL_CODE", sdSchulCode)
                    .queryParam("KEY", key)
                    .queryParam("MLSV_FROM_YMD", mlsvFromYmd)
                    .queryParam("MLSV_TO_YMD", mlsvToYmd)
//                    .queryParam("MLSV_YMD", mlsvYmd)
                    .toUriString();

            ResponseEntity<NeisResponse> responseEntity = restTemplate.getForEntity(uri, NeisResponse.class);

            HttpHeaders responseHeaders = responseEntity.getHeaders();

//            responseBody = responseEntity.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseBody;
        }
    }
}
