package com.progressoft.induction.paymentprocessingsystem.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.progressoft.induction.paymentprocessingsystem.model.Transaction;
import com.progressoft.induction.paymentprocessingsystem.receiver.model.TransactionMessage;
import com.progressoft.induction.paymentprocessingsystem.sender.model.TransactionResponseBody;
import com.progressoft.induction.paymentprocessingsystem.sender.model.TransactionResponseHeader;
import com.progressoft.induction.paymentprocessingsystem.sender.model.message;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Component
public class XmlConverter {
    private final XmlMapper xmlConverter = new XmlMapper();


    public String createXml(Transaction transaction) {
        try {
            message message = createTransactionResonse(transaction);

            setUpMapperConfiguration();
            return xmlConverter.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private message createTransactionResonse(Transaction transaction) {
        TransactionResponseBody transactionResponseBody = createRespnseBody(transaction);
        TransactionResponseHeader transactionMessageHeader = createMessageHeader(transaction);
        return new message(transactionMessageHeader,transactionResponseBody);

    }

    private TransactionResponseBody createRespnseBody(Transaction transaction) {
        TransactionResponseBody transactionResponseBody = new TransactionResponseBody();
        transactionResponseBody.setTransferReference("TR-" + new SecureRandom().nextInt(10000));
        transactionResponseBody.setFailureDetails(transaction.getFailuerDetails());

        return transactionResponseBody;
    }

    private TransactionResponseHeader createMessageHeader(Transaction transaction) {
        TransactionResponseHeader header = new TransactionResponseHeader();
        header.setReference(transaction.getReference());
        header.setDateTime(LocalDateTime.now());
        header.setStatus(transaction.getFailuerDetails().isEmpty()
                || transaction.getFailuerDetails().isBlank()
                ? "SUCCESS" : "FAILURE");
        header.setMessageType("TRANSFER");

        return header;

    }


    public Transaction createTransaction(String xmlString) {
        try {
            setUpMapperConfiguration();
            TransactionMessage message = xmlConverter.readValue(xmlString, TransactionMessage.class);
            return new Transaction(message.getHeader().getReference(), message.getBody().getDebitAccount(), message.getBody().getBeneficiaryType(),
                    message.getBody().getBeneficiaryValue(), message.getBody().getAmount(), message.getBody().getCurrency(), message.getBody().getValueDate()
                    , "");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error while reading transaction response");
        }

    }

    private void setUpMapperConfiguration() {
        xmlConverter.registerModule(new JavaTimeModule());
        xmlConverter.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}
