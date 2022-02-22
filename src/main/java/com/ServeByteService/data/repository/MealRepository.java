package com.ServeByteService.data.repository;

import com.ServeByteService.data.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByMealId(Long id);
    void deleteByRestaurantId(Long id);
}
