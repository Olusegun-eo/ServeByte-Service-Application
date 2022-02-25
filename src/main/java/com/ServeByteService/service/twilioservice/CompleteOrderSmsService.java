package com.ServeByteService.service.twilioservice;


import com.ServeByteService.data.dto.request.SmsSenderRequest;
import com.ServeByteService.web.exceptions.PhoneNumberDoesNotExistException;

public interface CompleteOrderSmsService {
//    It takes-in SmsSenderRequest and takes-in a request)
//    We have this one intreface that allows any implementation to send sms
//    FROM HERE, I AM GOING TO CREATE TWILIO IMPLEMENTATION OF THIS--->THE REASON FOR THIS INTERFACE
//     ....IS BCOS I CAN SWITCH THE INTERFACE WITHOUT CHANGING CODE
//    CREATE "CompleteOrderSmsImpl

    void sendSms(SmsSenderRequest smsRequest) throws PhoneNumberDoesNotExistException;
}
