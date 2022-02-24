package com.ServeByteService.data.model;

import lombok.Data;

import java.util.List;

@Data
public class ShortMessageSender {
    private List<String> numbers;
    private String message;
}
