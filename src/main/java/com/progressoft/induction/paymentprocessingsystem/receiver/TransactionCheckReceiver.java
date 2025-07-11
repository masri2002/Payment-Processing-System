package com.progressoft.induction.paymentprocessingsystem.receiver;

import com.progressoft.induction.paymentprocessingsystem.converter.XmlConverter;
import com.progressoft.induction.paymentprocessingsystem.model.Transaction;
import com.progressoft.induction.paymentprocessingsystem.service.TransactionChecker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@EnableJms
@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionCheckReceiver {
    private final XmlConverter xmlConverter;
    private final TransactionChecker transactionChecker;

    @JmsListener(destination = "${artemis.response.queue}")
    public void receiveTransaction(String response) {
        Transaction transaction = xmlConverter.createTransaction(response);
        transactionChecker.checkTransaction(transaction);
        log.info("Received transaction response: {}", response);
    }


}
