package com.example.demo.execption;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(IllegalOperationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails illegalOperationExceptionHandler(
            IllegalOperationException ex) {
        return new ErrorDetails(Instant.now(),
                ex.errorCode,
                getMessage(ex.errorCode, ex.placeHolder, Locale.getDefault()),
                HttpStatus.BAD_REQUEST.value());

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails recordNotFoundException(
            ResourceNotFoundException ex) {
        return new ErrorDetails(Instant.now(),
                ex.errorCode,
                getMessage(ex.errorCode, ex.placeHolder, Locale.getDefault()),
                HttpStatus.BAD_REQUEST.value());

    }

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails invalidInputException(
            InvalidInputException ex) {
        return new ErrorDetails(Instant.now(),
                ex.errorCode,
                getMessage(ex.errorCode, ex.placeHolder, Locale.getDefault()),
                HttpStatus.BAD_REQUEST.value());

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDetails globalExceptionHandler(Exception ex) {
        return new ErrorDetails(Instant.now(),
                getMessage(IErrorConstant.INTERNAL_ERROR, null, Locale.getDefault()),
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    private String getMessage(String errorCode, String[] args, Locale locale) {
        return messageSource.getMessage(errorCode, args, locale);
    }
}
