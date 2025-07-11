package com.progressoft.induction.paymentprocessingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
@Data
@AllArgsConstructor
public class Transaction {
    private String reference;
    private String debitAccount;
    private String beneficiaryType;
    private String beneficiary;
    private BigDecimal amount;
    private Currency currency;
    private LocalDate  valueDate;
    private String failuerDetails;
}
