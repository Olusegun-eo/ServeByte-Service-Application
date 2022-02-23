package com.ServeByteService.data.dto.request;

import com.ServeByteService.data.model.Channels;
import com.ServeByteService.data.model.PaystackBearer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentTransactionRequest {
    private BigDecimal amount;
    private String email;
    private String reference;
    private String callback_url;
    private Integer invoice_limit;
    private Channels[] channels;
    private String subAccount;
    private Integer transaction_charge;
    private PaystackBearer paystackBearer= PaystackBearer.ACCOUNT;

    public PaymentTransactionRequest(String amount, String email) {
        this.amount = BigDecimal.valueOf(Long.parseLong(amount));
        this.email = email;
    }
}
