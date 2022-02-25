package com.ServeByteService.service.twiloconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Data
public class TwilioConfiguration {
//    fields ti get these properties
    private String accountSid;
    private String authToken;
    private String trialNumber;

    public TwilioConfiguration() {
    }
}
