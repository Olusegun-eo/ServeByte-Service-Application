package com.ServeByteService.service.payment;

import com.ServeByteService.data.dto.request.PaymentTransactionRequest;
import com.ServeByteService.data.dto.response.PaymentTransactionResponse;

public interface PaymentService {
    PaymentTransactionResponse initializeTransaction(PaymentTransactionRequest paymentRequest);
}
