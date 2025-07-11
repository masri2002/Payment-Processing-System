package com.progressoft.induction.paymentprocessingsystem.sender.model;


import com.progressoft.induction.paymentprocessingsystem.converter.XmlConverter;
import com.progressoft.induction.paymentprocessingsystem.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableJms
@Slf4j
public class TransactionMQSender{

    private final JmsTemplate jmsTemplate;
    final private XmlConverter xmlConverter;
    private final String requestQueue;

    public TransactionMQSender(JmsTemplate jmsTemplate, XmlConverter xmlConverter, @Value("${artemis.request.queue}") String requestQueue) {
        this.jmsTemplate = jmsTemplate;
        this.xmlConverter = xmlConverter;
        this.requestQueue = requestQueue;
    }


    public void send(Transaction transaction) {
        log.info("Sending transaction {}", transaction);
        log.info("Message {}", xmlConverter.createXml(transaction));
        log.info("queue {}", requestQueue);
        jmsTemplate.send(requestQueue, session -> (session.createTextMessage(xmlConverter.createXml(transaction))));
    }
}
