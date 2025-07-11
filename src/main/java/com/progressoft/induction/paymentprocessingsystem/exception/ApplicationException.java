package com.progressoft.induction.paymentprocessingsystem.exception;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable t) {
        super(message, t);
    }
}
