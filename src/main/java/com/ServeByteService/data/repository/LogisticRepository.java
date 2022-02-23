package com.ServeByteService.data.repository;

import com.ServeByteService.data.model.City;
import com.ServeByteService.data.model.Logistics;
import com.ServeByteService.data.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogisticRepository extends JpaRepository<Logistics, Long> {
    List<Logistics> findByCityName(City city);
}
