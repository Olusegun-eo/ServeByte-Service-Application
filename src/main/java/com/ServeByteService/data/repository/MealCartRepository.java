package com.ServeByteService.data.repository;

import com.ServeByteService.data.model.Meal;
import com.ServeByteService.data.model.MealCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealCartRepository extends JpaRepository<MealCart, Long> {

}
