package com.ServeByteService.web.controllers;

import com.ServeByteService.data.dto.request.PaymentTransactionRequest;
import com.ServeByteService.data.dto.response.PaymentTransactionResponse;
import com.ServeByteService.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController("/api/meal/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("")
    public ResponseEntity<?> orderPayment(@RequestBody PaymentTransactionRequest paymentRequest){
        try {
            PaymentTransactionResponse response = paymentService.initializeTransaction(paymentRequest);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch(RestClientException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
