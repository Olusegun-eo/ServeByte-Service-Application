package com.ServeByteService.service.logistics;

import com.ServeByteService.data.dto.request.LogisticRequestDto;
import com.ServeByteService.data.model.City;
import com.ServeByteService.data.model.Logistics;
import com.ServeByteService.data.model.Restaurant;
import com.ServeByteService.data.repository.LogisticRepository;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.RestaurantDoesNotExistException;
import com.ServeByteService.web.exceptions.ServByteServiceApplicationException;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class LogisticServiceImpl implements LogisticService{
    @Autowired
    LogisticRepository logisticRepository;

    @Override
    public List<Logistics> getAllLogistics() {
        return logisticRepository.findAll();
    }

    @Override
    public Logistics findLogisticById(Long id) throws ServByteServiceApplicationException, RestaurantDoesNotExistException {
        return null;
    }

    @Override
    public Logistics createLogistics(LogisticRequestDto logisticRequestDto) throws ServByteServiceApplicationException, IOException {
        return null;
    }

    @Override
    public Restaurant updateLogisticDetails(Long id, JsonPatch patchPath) throws BusinessLogicException {
        return null;
    }

    @Override
    public List<Logistics> findByCityName(City city) throws RestaurantDoesNotExistException {
        return null;
    }
}
