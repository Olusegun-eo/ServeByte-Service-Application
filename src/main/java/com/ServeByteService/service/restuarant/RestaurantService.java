package com.ServeByteService.service.restuarant;

import com.ServeByteService.data.dto.request.RestaurantRequestDto;
import com.ServeByteService.data.model.City;
import com.ServeByteService.data.model.Restaurant;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.RestaurantDoesNotExistException;
import com.ServeByteService.web.exceptions.ServByteServiceApplicationException;
import com.github.fge.jsonpatch.JsonPatch;

import java.io.IOException;
import java.util.List;


public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Restaurant findRestaurantById(Long restuarantId) throws ServByteServiceApplicationException, RestaurantDoesNotExistException;
    Restaurant createRestaurant(RestaurantRequestDto restaurantRequestDto) throws ServByteServiceApplicationException, IOException;
    Restaurant updateRestaurantDetails(Long restuarantId, JsonPatch patchPath) throws BusinessLogicException;
    List<Restaurant> findByCityName(City city) throws RestaurantDoesNotExistException;
}
