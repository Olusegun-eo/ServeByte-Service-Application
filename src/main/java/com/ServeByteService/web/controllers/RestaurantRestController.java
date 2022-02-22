package com.ServeByteService.web.controllers;



import com.github.fge.jsonpatch.JsonPatch;
import com.ServeByteService.data.dto.request.RestaurantRequestDto;
import com.ServeByteService.data.model.Restaurant;
import com.ServeByteService.service.restuarant.RestaurantService;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.ServByteServiceApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantRestController {

    private Restaurant restaurant;

    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<?> findRestaurants(){
        List<Restaurant> restuarantList = restaurantService.getAllRestaurants();
        return ResponseEntity.status(HttpStatus.OK).body(restuarantList);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createRestaurant(@ModelAttribute RestaurantRequestDto restaurantRequestDto) throws ServByteServiceApplicationException {
        try {
            Restaurant savedRestaurant = restaurantService.createRestaurant(restaurantRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(savedRestaurant);
        }catch (BusinessLogicException | IllegalArgumentException | IOException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<?> updateRestaurantDetails(@PathVariable Long id, JsonPatch restuarantPatch){
        try{
            Restaurant updateRestaurant= restaurantService.updateRestaurantDetails(id, restuarantPatch);
            return ResponseEntity.status(HttpStatus.OK).body(updateRestaurant);
        } catch (BusinessLogicException | Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}



//DOCUMENTAION ON Creating an SMS dashboard in Java with Spring Boot
//https://www.twilio.com/blog/sms-dashboard-java-spring-boot