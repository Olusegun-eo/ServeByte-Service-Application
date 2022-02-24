package com.ServeByteService.data.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CompleteServiceDto {
    private String message;
    private List<String> numbers;
}
