package com.ServeByteService.data.repository;

import com.ServeByteService.data.model.City;
import com.ServeByteService.data.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCityName(City city);
    Optional<Restaurant> findByRestaurantEmail(String email);
}