package com.progressoft.induction.paymentprocessingsystem.sender.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class message {
    @JacksonXmlProperty(localName = "header")
    private TransactionResponseHeader header;

    @JacksonXmlProperty(localName = "body")
    private TransactionResponseBody body;
}
