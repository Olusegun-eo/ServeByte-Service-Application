package com.ServeByteService.service.mealservice;

import com.ServeByteService.data.dto.request.MealCartRequestDto;
import com.ServeByteService.data.dto.request.MealUpdateDto;
import com.ServeByteService.data.dto.response.MealCartResponseDto;
import com.ServeByteService.data.model.Meal;
import com.ServeByteService.data.model.MealCart;
import com.ServeByteService.data.model.MealItem;
import com.ServeByteService.data.model.User;
import com.ServeByteService.data.repository.MealCartRepository;
import com.ServeByteService.data.repository.MealRepository;
import com.ServeByteService.data.repository.UserRepository;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.MealDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class MealCartServiceImpl implements MealCartService {

    @Autowired
    MealCartRepository mealCartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MealRepository mealRepository;

    @Override
    public MealCartResponseDto addMealToCart(MealCartRequestDto mealCartRequestDto) throws BusinessLogicException, MealDoesNotExistException {
//        check if user exist
        Optional<User> query = userRepository.findById(mealCartRequestDto.getMealId());
        if (query.isEmpty()) {
            throw new IllegalArgumentException("Meal with ID " + mealCartRequestDto.getMealId() + " not found");
        }
        User existingUser = query.get();
//        check product exits
        Meal meal = mealRepository.findById(mealCartRequestDto.getMealId()).orElse(null);
        if (meal == null)
            throw new MealDoesNotExistException("Meal with ID " + mealCartRequestDto.getMealId() + " does not exist");
        else
            throw new IllegalArgumentException("not Found");
    }


    @Override
    public MealCartResponseDto viewCart(Long cartId) throws BusinessLogicException {
        return null;
    }

    @Override
    public MealCartResponseDto updateCartMeal(MealUpdateDto mealUpdateDto) throws BusinessLogicException {
        return null;
    }

}









