package com.example.school_meal_menu_backend.dto.neis;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class NeisResponse {

    private List<MealServiceDietInfo> mealServiceDietInfo;
}
