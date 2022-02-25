package com.ServeByteService.service.payment;

import com.ServeByteService.data.dto.request.PaymentTransactionRequest;
import com.ServeByteService.data.dto.response.PaymentTransactionResponse;

public interface PaymentService {
    PaymentTransactionResponse initializeTransaction(PaymentTransactionRequest paymentRequest);
}


//VERY FAST API THAT I CAN EASILY CHECK....
//uniRest
//finClient