package com.ServeByteService.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String restaurantName;
    private String restaurantEmail;
    private String restaurantPhoneNumber;
    private String logoUrl;
    private City cityName;

}
