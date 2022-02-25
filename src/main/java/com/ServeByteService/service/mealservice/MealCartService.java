package com.ServeByteService.service.mealservice;

import com.ServeByteService.data.dto.request.MealCartRequestDto;
import com.ServeByteService.data.dto.request.MealUpdateDto;
import com.ServeByteService.data.dto.response.MealCartResponseDto;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.MealDoesNotExistException;

public interface MealCartService {

    MealCartResponseDto addMealToCart(MealCartRequestDto mealCartRequestDto) throws BusinessLogicException, MealDoesNotExistException;
    MealCartResponseDto viewCart(Long cartId) throws BusinessLogicException;
    MealCartResponseDto updateCartMeal(MealUpdateDto mealUpdateDto) throws BusinessLogicException;
}
