package com.ServeByteService.data.dto.request;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Data
public class MealDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String logoUrl;
    private String description;
    @CreationTimestamp
    private LocalDateTime mealPrepTime;
}
