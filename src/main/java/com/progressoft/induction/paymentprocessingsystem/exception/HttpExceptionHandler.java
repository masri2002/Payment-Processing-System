package com.progressoft.induction.paymentprocessingsystem.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class HttpExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseBody> handleGenericException(Exception ex) {
        log.error("Unexpected error occurred: {}", ex.getMessage(), ex);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ExceptionResponseBody responseBody = new ExceptionResponseBody(
                status.getReasonPhrase(),
                status.value(),
                "Internal-Server-Error",
                "An unexpected error occurred. Please try again later.",
                LocalDate.now()
        );
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(responseBody);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponseBody> handleApplicationException(ApplicationException ex) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        log.error(ex.getMessage(), ex);

        ExceptionResponseBody responseBody = new ExceptionResponseBody(
                status.getReasonPhrase(),
                status.value(),
                "Application-Error",
                ex.getMessage(),
                LocalDate.now()
        );
        return ResponseEntity.status(status).body(responseBody);
    }

    @ExceptionHandler(MissingRequestDataException.class)
    public ResponseEntity<ExceptionResponseBody> handleMissingRequestDataException(MissingRequestDataException ex) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        log.error(ex.getMessage(), ex);
        ExceptionResponseBody responseBody = new ExceptionResponseBody(
                status.getReasonPhrase(),
                status.value(),
                "Missing-Required-Data",
                ex.getMessage(),
                LocalDate.now()
        );
        return ResponseEntity.status(status).body(responseBody);
    }

    @ExceptionHandler(MappingFailureException.class)
    public ResponseEntity<ExceptionResponseBody> handleDtoMappingFailedException(MappingFailureException ex) {
        log.error(ex.getMessage(), ex);
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionResponseBody responseBody = new ExceptionResponseBody(
                status.getReasonPhrase(),
                status.value(),
                "Mapping-Failure-Exception",
                ex.getMessage(),
                LocalDate.now()
        );
        return ResponseEntity.status(status).body(responseBody);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponseBody> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        log.error(ex.getMessage(), ex);
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionResponseBody responseBody = new ExceptionResponseBody(
                status.getReasonPhrase(),
                status.value(),
                "Method-Argument-Type-Mismatch",
                String.format("Cannot convert field '%s' with the value '%s' into a '%s' datatype.",
                        ex.getName(),
                        ex.getValue(),
                        Objects.requireNonNull(ex.getRequiredType())
                                .getSimpleName()),
                LocalDate.now()
        );
        return ResponseEntity.status(status).body(responseBody);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponseBody> handleUnableToReadRequest(HttpMessageNotReadableException ex) {
        log.error(ex.getMessage(), ex);
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionResponseBody responseBody = new ExceptionResponseBody(
                status.getReasonPhrase(),
                status.value(),
                "Http-Message-Not-Readable-Exception",
                "Server can't read your request, use proper ContentType",
                LocalDate.now()
        );
        return ResponseEntity.status(status).body(responseBody);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseBody> handleNotFoundException(NotFoundException ex) {
        log.error(ex.getMessage(), ex);
        final HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponseBody responseBody = new ExceptionResponseBody(
                status.getReasonPhrase(),
                status.value(),
                "Not-Found",
                ex.getMessage(),
                LocalDate.now()
        );
        return ResponseEntity.status(status).body(responseBody);
    }
}

