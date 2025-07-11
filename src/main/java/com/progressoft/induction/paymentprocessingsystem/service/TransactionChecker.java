package com.progressoft.induction.paymentprocessingsystem.service;

import com.progressoft.induction.paymentprocessingsystem.model.Transaction;
import com.progressoft.induction.paymentprocessingsystem.sender.model.TransactionMQSender;
import com.progressoft.induction.paymentprocessingsystem.validtor.TransactionValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionChecker {

    private final TransactionValidator transactionValidator;


    private final TransactionMQSender transactionMQSender;

    public void checkTransaction(Transaction transaction) {
        transactionValidator.validateTransferInputs(transaction);
        transactionMQSender.send(transaction);
    }
}
