package com.ServeByteService.web.controllers;

import com.ServeByteService.data.dto.request.LogisticRequestDto;
import com.ServeByteService.data.dto.request.RestaurantRequestDto;
import com.ServeByteService.data.model.Logistics;
import com.ServeByteService.data.model.Restaurant;
import com.ServeByteService.service.logistics.LogisticService;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.ServByteServiceApplicationException;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/logistic")
public class LogisticController {

    Logistics logistics;

    @Autowired
    LogisticService logisticService;


    @GetMapping
    public ResponseEntity<?> findLogistic() {
        List<Logistics> restaurantList = logisticService.getAllLogistics();
        return ResponseEntity.status(HttpStatus.OK).body(restaurantList);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createLogistics(@ModelAttribute LogisticRequestDto logisticRequestDto) throws ServByteServiceApplicationException {
        try {
            Logistics savedLogistic = logisticService.createLogistics(logisticRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(savedLogistic);
        } catch (BusinessLogicException | IllegalArgumentException | IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<?> updateLogisticDetails(@PathVariable Long id, JsonPatch logisticPatch) {
        try {
            Logistics updatedLogistic = logisticService.updateLogisticDetails(id, logisticPatch);
            return ResponseEntity.status(HttpStatus.OK).body(updatedLogistic);
        } catch (BusinessLogicException | Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
