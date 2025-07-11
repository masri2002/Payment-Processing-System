package com.progressoft.induction.paymentprocessingsystem.sender.model;

import lombok.Data;

@Data
public class TransactionResponseBody {
    private String transferReference;
    private String failureDetails;
}
