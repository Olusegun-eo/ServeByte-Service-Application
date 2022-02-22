package com.ServeByteService.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentTransactionResponse {
    private String status;
    private String message;
    private Data data;
}
