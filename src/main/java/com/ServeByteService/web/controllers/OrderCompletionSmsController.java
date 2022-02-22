package com.ServeByteService.web.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderCompletionSmsController {

    @Value("{}")
    private String myTwilioNumber;

    public static class messageDetails{
        public List<String> numbers;
        public String messages;
    }



}
