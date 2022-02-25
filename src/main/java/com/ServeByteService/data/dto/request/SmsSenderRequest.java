package com.ServeByteService.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SmsSenderRequest {
//    If someone wants to send sms request, they have to provide
    private final String phoneNumber; //destination
    private final String message;

//    We can add, constructor, getters and toString but becos of @DATa, toSting, getters and stters already exists


    public SmsSenderRequest(@JsonProperty("phoneNumber")String phoneNumber, @JsonProperty("message")String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }



}
