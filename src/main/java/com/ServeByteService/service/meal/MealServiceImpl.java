package com.ServeByteService.service.meal;


import com.ServeByteService.data.model.Meal;
import com.ServeByteService.data.repository.MealCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MealServiceImpl implements MealService{

    List<Meal> meals = new ArrayList<>();

    @Autowired
    MealCartRepository mealRepository;

    @Override
    public List<Meal> getAllMeals() {
        return getAllMeals();
    }

    @Override
    public Meal findByMealId(Long id) {
        return null;
    }

    @Override
    public Meal upload(List<Meal> mealList) {
        return null;
    }

    @Override
    public void deleteAll() {
        mealRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {

//         mealRepository.delete();
    }
}
