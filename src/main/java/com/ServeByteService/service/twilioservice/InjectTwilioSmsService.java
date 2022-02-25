package com.ServeByteService.service.twilioservice;

import com.ServeByteService.data.dto.request.SmsSenderRequest;
import com.ServeByteService.web.exceptions.PhoneNumberDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("twilio")
public class InjectTwilioSmsService {
    private  final SmsSenderServiceImpl twilioSmsSender;

    @Autowired
    public InjectTwilioSmsService(SmsSenderServiceImpl twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }

    public void sendSms(SmsSenderRequest smsRequest) throws PhoneNumberDoesNotExistException {
        twilioSmsSender.sendSms(smsRequest);;
    }
}
