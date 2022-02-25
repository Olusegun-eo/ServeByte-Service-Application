package com.ServeByteService.data.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealUpdateDto {
    private Long userId;
    private Long itemId;
}
