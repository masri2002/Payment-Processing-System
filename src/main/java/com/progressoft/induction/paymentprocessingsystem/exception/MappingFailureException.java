package com.progressoft.induction.paymentprocessingsystem.exception;

public class MappingFailureException extends ApplicationException {
    public MappingFailureException(String message) {
        super(message);
    }
    public MappingFailureException(String message, Throwable t) {
        super(message, t);
    }
}
