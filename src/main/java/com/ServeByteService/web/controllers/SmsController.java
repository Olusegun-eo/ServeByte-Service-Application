package com.ServeByteService.web.controllers;

import com.ServeByteService.data.dto.request.SmsSenderRequest;
import com.ServeByteService.service.twilioservice.InjectTwilioSmsService;
import com.ServeByteService.web.exceptions.PhoneNumberDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class SmsController {

    private final InjectTwilioSmsService service;

    @Autowired
    public SmsController(InjectTwilioSmsService service) {
        this.service = service;
    }

//    This is a post request
//    Hence, I can annotate SmsSenderRequest feilds with "@JsonProperty"("fieldName")
//    @Valid here is to validate both number and message must not be valid
    @PostMapping
    public void sendSms(@RequestBody SmsSenderRequest smsRequest) throws PhoneNumberDoesNotExistException {
        service.sendSms(smsRequest);
    }
}
