package com.ServeByteService.data.dto.request;

import lombok.Data;

@Data
public class MealCartRequestDto {
    private Long userId;
    private Long mealId;
    private Integer quantity;
}
