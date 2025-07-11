package com.progressoft.induction.paymentprocessingsystem.receiver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionMessageBody {
    private String debitAccount;
    private String beneficiaryType;
    private String beneficiaryValue;
    private BigDecimal amount;
    private Currency currency;
    private LocalDate valueDate;
}
