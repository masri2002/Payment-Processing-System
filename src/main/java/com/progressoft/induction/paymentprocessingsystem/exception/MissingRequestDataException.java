package com.progressoft.induction.paymentprocessingsystem.exception;

public class MissingRequestDataException extends ApplicationException {
    public MissingRequestDataException(String message) {
        super(message);
    }
    public MissingRequestDataException(String message, Throwable t) {
        super(message, t);
    }
}
