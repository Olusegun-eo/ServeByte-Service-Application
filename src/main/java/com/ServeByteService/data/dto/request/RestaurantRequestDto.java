package com.ServeByteService.data.dto.request;

import com.ServeByteService.data.model.City;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
public class RestaurantRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private City city;
    private MultipartFile logo;
}
