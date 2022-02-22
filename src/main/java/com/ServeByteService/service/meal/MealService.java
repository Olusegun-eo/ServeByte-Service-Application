package com.ServeByteService.service.meal;

import com.ServeByteService.data.model.Meal;

import java.util.List;

public interface MealService {

     List<Meal>getAllMeals();
     Meal findByMealId(Long id);
     Meal upload(List<Meal> mealList);
      void deleteAll();
      void deleteById(Long id);
}
