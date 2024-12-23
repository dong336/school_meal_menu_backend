package com.example.school_meal_menu_backend.dto.neis;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class MealServiceDietInfo {

    private List<Head> head;
    private List<Row> row;
}
