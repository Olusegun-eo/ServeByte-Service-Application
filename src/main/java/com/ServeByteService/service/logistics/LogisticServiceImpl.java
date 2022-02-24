package com.ServeByteService.service.logistics;

import com.ServeByteService.data.dto.request.LogisticRequestDto;
import com.ServeByteService.data.model.City;
import com.ServeByteService.data.model.Logistics;
import com.ServeByteService.data.repository.LogisticRepository;
import com.ServeByteService.service.cloud.cloudinary.CloudService;
import com.ServeByteService.web.exceptions.LogisticDoesNotExistException;
import com.ServeByteService.web.exceptions.BusinessLogicException;
import com.ServeByteService.web.exceptions.ServByteServiceApplicationException;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class LogisticServiceImpl implements LogisticService{
    @Autowired
    LogisticRepository logisticRepository;

    @Autowired
    private CloudService cloudService;

    @Override
    public List<Logistics> getAllLogistics() {
        return logisticRepository.findAll();
    }

    @Override
    public List<Logistics> findByCityName(City city) throws LogisticDoesNotExistException {
        if(city == null) throw new IllegalArgumentException("Id can not be null");
        List<Logistics> queryResult = logisticRepository.findByCityName(city);
        if(queryResult!=null) return queryResult;
        else throw new LogisticDoesNotExistException("Product with ID: does not not exist");
    }

    public Logistics findLogisticById(Long id) throws LogisticDoesNotExistException {
        if(id == null) throw new IllegalArgumentException("Id can not be null");
        Optional<Logistics> queryResult = logisticRepository.findById(id);
        if(queryResult.isPresent()) { return queryResult.get(); }
        throw new LogisticDoesNotExistException("Dispatcher with ID: " + id + "does not not exist");
    }


    @Override
    public Logistics createLogistics(LogisticRequestDto logisticRequestDto) throws ServByteServiceApplicationException, IOException {
        if(logisticRequestDto == null) throw new BusinessLogicException("Argument can not be null");
        if(logisticRepository.findByLogisticEmail(logisticRequestDto.getEmail()).isPresent() ){
            throw new ServByteServiceApplicationException("Restaurant with email " + logisticRequestDto.getCity() + "already exists");
        }

        Logistics logistics = new Logistics();
        try{
            if(logisticRequestDto.getLogo() != null) {
                Map<?, ?> uploadResult = cloudService.uploadLogo(logisticRequestDto.getLogo().getBytes(), ObjectUtils.asMap(
                        "public_id",
                        "inventory/" + logisticRequestDto.getLogo().getOriginalFilename(),
                        "overwrite", true));
                logistics.setLogisticLogo(uploadResult.get("url").toString());
            }
        }catch(IOException e){ e.printStackTrace();  }

        logistics.setLogisticName(logisticRequestDto.getName());
        logistics.setLogisticEmail(logisticRequestDto.getEmail());
        logistics.setLogisticPhone(logisticRequestDto.getPhoneNumber());
        //restaurant.setLogoUrl(restaurantRequestDto.getLogo().getBytes().toString());
        logistics.setCityName(City.valueOf(logisticRequestDto.getCity().toString()));
        return logisticRepository.save(logistics);
    }

    private Logistics saveOrUpdateLogistic(Logistics logistics) throws BusinessLogicException {
        if(logistics == null){ throw new BusinessLogicException("Product can not be null "); }
        return logisticRepository.save(logistics);
    }

    @Override
    public Logistics updateLogisticDetails(Long id, JsonPatch logisticPatch) throws BusinessLogicException{
        Optional<Logistics> logisticQuery =logisticRepository.findById(id);
        if(logisticQuery.isEmpty()){
            throw new BusinessLogicException("Product with ID:" + id + "Does not exist");
        }
        Logistics targetLogistic = logisticQuery.get();
        try {
            targetLogistic = applyPatchToLogistic(logisticPatch, targetLogistic);
            return saveOrUpdateLogistic(targetLogistic);

        } catch (JsonPatchException | JsonProcessingException |BusinessLogicException jsonException){
            throw new BusinessLogicException("Logistic update failed");
        }

    }

    private Logistics applyPatchToLogistic(JsonPatch logisticPatch, Logistics targetLogistic) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched= logisticPatch.apply(objectMapper.convertValue(logisticPatch, JsonNode.class));
        return objectMapper.treeToValue(patched, Logistics.class);
    }


}
