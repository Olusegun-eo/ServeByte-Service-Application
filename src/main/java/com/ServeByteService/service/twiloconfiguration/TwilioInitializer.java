package com.ServeByteService.service.twiloconfiguration;

import com.twilio.Twilio;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TwilioInitializer {
//    ADD A LOGGER
    private final Logger LOGGER= LoggerFactory.getLogger(TwilioInitializer.class);
    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
//        pass account twilioInitializer to the LOGGER
        LOGGER.info("Twilio initailized ... with account sid {}", twilioConfiguration.getAccountSid());
    }
}
//After here, I create an interface class to send Sms "CompleteOderSms"