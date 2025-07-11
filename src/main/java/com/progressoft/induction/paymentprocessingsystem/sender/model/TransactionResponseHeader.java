package com.progressoft.induction.paymentprocessingsystem.sender.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionResponseHeader {
    private String reference;
    private LocalDateTime dateTime;
    private String messageType;
    private String status;
}
