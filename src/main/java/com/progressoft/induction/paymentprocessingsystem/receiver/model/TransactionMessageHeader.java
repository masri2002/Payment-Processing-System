package com.progressoft.induction.paymentprocessingsystem.receiver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionMessageHeader {
    private String reference;
    private LocalDateTime dateTime;
    private String status;
    private String messageType;
}
