package com.ServeByteService.service.twilioservice;

import com.ServeByteService.data.dto.request.SmsSenderRequest;
import com.ServeByteService.service.twiloconfiguration.TwilioConfiguration;
import com.ServeByteService.web.exceptions.PhoneNumberDoesNotExistException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("twilio")
public class SmsSenderServiceImpl implements CompleteOrderSmsService{
//This was injected becos we need to get token Number
private static final Logger LOGGER= LoggerFactory.getLogger(SmsSenderServiceImpl.class);
private final TwilioConfiguration twiloconfiguration;
    @Autowired
    public SmsSenderServiceImpl(TwilioConfiguration twiloconfiguration) {
        this.twiloconfiguration = twiloconfiguration;
    }

    @Override
    public void sendSms(SmsSenderRequest smsRequest) throws PhoneNumberDoesNotExistException {
//        TO Send sms with Twilio API I have to  "Message" library "import com.twilio.rest.api.v2010.account.Message;"
        if(isPhoneNumberValid(smsRequest.getPhoneNumber())){
            PhoneNumber to= new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from= new PhoneNumber(twiloconfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator createMessage = Message.creator(to, from, message);
            smsRequest.getMessage();

//               We can create the actual message here
            createMessage.create();
            LOGGER.info("Send sms {}" + smsRequest);
        } else{
            throw new PhoneNumberDoesNotExistException("Phone number [ "+ smsRequest.getPhoneNumber()+ "] does not exist");
        }


    }

//    implement phone number validator
    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }

}
