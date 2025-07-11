package com.progressoft.induction.paymentprocessingsystem.receiver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionMessage {
    private TransactionMessageHeader header;
    private TransactionMessageBody body;

}
