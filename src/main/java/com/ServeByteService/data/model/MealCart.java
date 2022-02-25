package com.ServeByteService.data.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MealCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private LocalDateTime mealPrepTime = LocalDateTime.now();
    private Double totalPrice;
    @OneToMany
    private List<Meal> product;
    @OneToMany(cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
    private List<MealItem> mealList;

    public void addMeal(MealItem item){
        if(mealList == null){
            mealList = new ArrayList<>();
        }
        mealList.add(item);
    }


}
