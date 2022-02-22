package com.ServeByteService.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EnableJpaRepositories
public class OrderMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List <Meal> mealList; //    Meal Price;
    @OneToMany
    private List<Logistics> logisticList; //    Logistics logisticPrice;
    @OneToMany
    private List<Restaurant> restaurantList; // Restaurant name, //Restaurant location;

}
