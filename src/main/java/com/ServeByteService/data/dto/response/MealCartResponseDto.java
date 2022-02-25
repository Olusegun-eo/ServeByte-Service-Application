package com.ServeByteService.data.dto.response;

import com.ServeByteService.data.model.MealItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MealCartResponseDto {
    private List<MealItem> mealItems;
    private double totalPrice;
}
