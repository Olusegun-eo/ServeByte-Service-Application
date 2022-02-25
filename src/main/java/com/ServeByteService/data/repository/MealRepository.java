package com.ServeByteService.data.repository;

import com.ServeByteService.data.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {

}
