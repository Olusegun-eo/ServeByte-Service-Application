package com.ServeByteService.web.controllers;



import com.ServeByteService.service.twilo.CompleteOderSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class CompleteOrderServiceController {

    @Autowired
    CompleteOderSmsService completeOderSmsService;


//    public ResponseEntity<?>(CompleteserviceDto completeserviceDto) { }

}
