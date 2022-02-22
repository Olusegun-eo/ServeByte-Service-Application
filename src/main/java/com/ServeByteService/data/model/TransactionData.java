package com.ServeByteService.data.model;

import lombok.Data;

@Data
public class TransactionData {
    private String authorization_url;
    private String access_code;
    private String reference;
}
