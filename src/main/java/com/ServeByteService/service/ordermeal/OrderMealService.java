package com.ServeByteService.service.ordermeal;

import com.ServeByteService.data.model.MealItem;
import com.ServeByteService.data.model.Restaurant;

import java.util.List;

public interface OrderMealService {
    List <Restaurant> restaurantList();
    List<MealItem> getAllMealItems();
}
