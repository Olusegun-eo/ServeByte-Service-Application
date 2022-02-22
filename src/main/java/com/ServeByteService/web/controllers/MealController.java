package com.ServeByteService.web.controllers;


import com.ServeByteService.data.model.Meal;
import com.ServeByteService.data.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {

    @Autowired
    MealRepository mealRepository;

    @GetMapping("/")
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @GetMapping("/{id}")
    public Meal findByMealId(@PathVariable("id") Long id) {
//        return mealRepository.findByMealId(id);
        return null;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Meal> mealList) {
//        mealRepository.save(mealList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        mealRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
//        mealRepository.delete();
    }

}
