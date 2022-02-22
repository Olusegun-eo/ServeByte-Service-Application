package com.ServeByteService.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mealId;
    private String mealName;
    private Double mealPrice;
    private String logoUrl;
    private String description;
    @CreationTimestamp
    private LocalDateTime mealPrepTime;
}

