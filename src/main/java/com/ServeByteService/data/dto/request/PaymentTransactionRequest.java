package com.ServeByteService.data.dto.request;

import com.ServeByteService.data.model.Channels;
import com.ServeByteService.data.model.PaystackBearer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentTransactionRequest {
    private String amount;
    private String email;
    private String reference;
    private String callback_url;
    private Integer invoice_limit;
    private Channels[] channels;
    private String subAccount;
    private Integer transaction_charge;
    private PaystackBearer paystackBearer= PaystackBearer.ACCOUNT;
}
