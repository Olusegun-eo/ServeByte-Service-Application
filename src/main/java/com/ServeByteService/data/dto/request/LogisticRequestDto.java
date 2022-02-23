package com.ServeByteService.data.dto.request;

import com.ServeByteService.data.model.City;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class LogisticRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private City city;
    private MultipartFile logo;
}
