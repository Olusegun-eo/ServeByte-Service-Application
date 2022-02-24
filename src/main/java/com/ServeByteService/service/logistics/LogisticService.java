package com.ServeByteService.service.logistics;

import com.ServeByteService.data.dto.request.LogisticRequestDto;
import com.ServeByteService.data.dto.request.RestaurantRequestDto;
import com.ServeByteService.data.model.City;
import com.ServeByteService.data.model.Logistics;
import com.ServeByteService.data.model.Restaurant;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.LogisticDoesNotExistException;
import com.ServeByteService.web.exceptions.RestaurantDoesNotExistException;
import com.ServeByteService.web.exceptions.ServByteServiceApplicationException;
import com.github.fge.jsonpatch.JsonPatch;

import java.io.IOException;
import java.util.List;

public interface LogisticService {
    List<Logistics> getAllLogistics();
    Logistics findLogisticById(Long id) throws ServByteServiceApplicationException, RestaurantDoesNotExistException, LogisticDoesNotExistException;
    Logistics createLogistics(LogisticRequestDto logisticRequestDto) throws ServByteServiceApplicationException, IOException;
    Restaurant updateLogisticDetails(Long id, JsonPatch patchPath) throws BusinessLogicException;
    List<Logistics> findByCityName(City city) throws RestaurantDoesNotExistException;
}
