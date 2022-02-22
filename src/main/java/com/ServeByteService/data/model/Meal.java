package com.ServeByteService.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mealId;
    private String mealName;
    private Double mealPrice;
    private String logoUrl;
    private String description;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<MealItem> mealItems;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private  Restaurant restaurant;

    @CreationTimestamp
    private LocalDateTime mealPrepTime;
}
