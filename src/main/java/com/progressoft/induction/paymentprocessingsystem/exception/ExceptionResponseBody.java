package com.progressoft.induction.paymentprocessingsystem.exception;

import java.time.LocalDate;

public record ExceptionResponseBody(
        String status,
        Integer statusCode,
        String code,
        String message,
        LocalDate timestamp){}

