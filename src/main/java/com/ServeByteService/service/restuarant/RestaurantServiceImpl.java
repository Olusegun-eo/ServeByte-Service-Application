package com.ServeByteService.service.restuarant;

import com.ServeByteService.data.model.City;
//import com.ServeByteService.data.repository.CityRepository;
import com.ServeByteService.service.cloud.cloudinary.CloudService;
import com.ServeByteService.web.exceptions.RestaurantDoesNotExistException;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.ServeByteService.data.dto.request.RestaurantRequestDto;
import com.ServeByteService.data.model.Restaurant;
import com.ServeByteService.data.repository.RestaurantRepository;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.ServByteServiceApplicationException;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CloudService cloudService;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findByCityName(City city) throws RestaurantDoesNotExistException {
        if(city == null) throw new IllegalArgumentException("Id can not be null");
        List<Restaurant> queryResult = restaurantRepository.findByCityName(city);
        if(queryResult!=null) return queryResult;
        else throw new RestaurantDoesNotExistException("Product with ID: does not not exist");
    }

    @Override
    public Restaurant findRestaurantById(Long restuarantId) throws RestaurantDoesNotExistException {
        if(restuarantId == null) throw new IllegalArgumentException("Id can not be null");
        Optional<Restaurant> queryResult = restaurantRepository.findById(restuarantId);
        if(queryResult.isPresent())
        { return queryResult.get(); }
        throw new RestaurantDoesNotExistException("Product with ID: " + restuarantId + "does not not exist");
    }

    @Override
    public Restaurant createRestaurant(RestaurantRequestDto restaurantRequestDto) throws ServByteServiceApplicationException, IOException {
        if(restaurantRequestDto == null) throw new BusinessLogicException("Argument can not be null");
        if(restaurantRepository.findByRestaurantEmail(restaurantRequestDto.getEmail()).isPresent() ){
            throw new ServByteServiceApplicationException("Restaurant with email " + restaurantRequestDto.getCity() + "already exists");
        }

        Restaurant restaurant = new Restaurant();
        try{
            if(restaurantRequestDto.getLogo() != null) {
                Map<?, ?> uploadResult = cloudService.uploadLogo(restaurantRequestDto.getLogo().getBytes(), ObjectUtils.asMap(
                        "public_id",
                        "inventory/" + restaurantRequestDto.getLogo().getOriginalFilename(),
                        "overwrite", true));
                restaurant.setLogoUrl(uploadResult.get("url").toString());
            }
        }catch(IOException e){ e.printStackTrace();  }

        restaurant.setRestaurantName(restaurantRequestDto.getName());
        restaurant.setRestaurantEmail(restaurantRequestDto.getEmail());
        restaurant.setRestaurantPhoneNumber(restaurantRequestDto.getPhoneNumber());
        //restaurant.setLogoUrl(restaurantRequestDto.getLogo().getBytes().toString());
        restaurant.setCityName(City.valueOf(restaurantRequestDto.getCity().toString()));
        return restaurantRepository.save(restaurant);
    }

    private Restaurant saveOrUpdateRestaurant(Restaurant restaurant) throws BusinessLogicException {
        if(restaurant == null){ throw new BusinessLogicException("Product can not be null "); }
        return restaurantRepository.save(restaurant);
    }


    @Override
    public Restaurant updateRestaurantDetails(Long restuarantId, JsonPatch restaurantPatch) throws BusinessLogicException{
        Optional<Restaurant> restaurantQuery =restaurantRepository.findById(restuarantId);
        if(restaurantQuery.isEmpty()){
            throw new BusinessLogicException("Product with ID:" + restuarantId + "Does not exist");
        }
        Restaurant targetRestaurant = restaurantQuery.get();
        try {
            targetRestaurant = applyPatchToRestaurant(restaurantPatch, targetRestaurant);
            return saveOrUpdateRestaurant(targetRestaurant);
        } catch (JsonPatchException | JsonProcessingException |BusinessLogicException jsonException){
            throw new BusinessLogicException("Product update failed");
        }
    }

    private Restaurant applyPatchToRestaurant(JsonPatch restaurantPatch, Restaurant targetRestaurant) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched= restaurantPatch.apply(objectMapper.convertValue(targetRestaurant, JsonNode.class));
        return objectMapper.treeToValue(patched, Restaurant.class);
    }

}
