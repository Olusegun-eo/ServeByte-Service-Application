package com.ServeByteService.data.repository;

import com.ServeByteService.data.model.Meal;
import com.ServeByteService.data.model.MealItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealItemRepository extends JpaRepository<MealItem, Long> {
    List<MealItem> findByMealId(Long id);
}
