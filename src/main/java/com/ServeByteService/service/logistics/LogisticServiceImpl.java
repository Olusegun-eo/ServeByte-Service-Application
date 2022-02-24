package com.ServeByteService.service.logistics;

import com.ServeByteService.data.dto.request.LogisticRequestDto;
import com.ServeByteService.data.model.City;
import com.ServeByteService.data.model.Logistics;
import com.ServeByteService.data.model.Restaurant;
import com.ServeByteService.data.repository.LogisticRepository;
import com.ServeByteService.web.exceptions.LogisticDoesNotExistException;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.RestaurantDoesNotExistException;
import com.ServeByteService.web.exceptions.ServByteServiceApplicationException;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class LogisticServiceImpl implements LogisticService{
    @Autowired
    LogisticRepository logisticRepository;

    @Override
    public List<Logistics> getAllLogistics() {
        return logisticRepository.findAll();
    }

    @Override
    public Logistics findLogisticById(Long id) throws ServByteServiceApplicationException, RestaurantDoesNotExistException, LogisticDoesNotExistException {
        if(logisticRepository == null) throw new IllegalArgumentException("The Logistic Company with ID " + id + "is not not Found");
        Optional<Logistics> queryResult = logisticRepository.findById(id);
        if(queryResult.isPresent()){
            throw new LogisticDoesNotExistException("The Logistic Company does not exist");
        }
        return null;
    }

    @Override
    public Logistics createLogistics(LogisticRequestDto logisticRequestDto) throws ServByteServiceApplicationException, IOException {
        return null;
    }

    @Override
    public Restaurant updateLogisticDetails(Long id, JsonPatch logisticPatch) throws BusinessLogicException {
        return null;
    }

    @Override
    public List<Logistics> findByCityName(City city) throws RestaurantDoesNotExistException {
        return null;
    }
}
