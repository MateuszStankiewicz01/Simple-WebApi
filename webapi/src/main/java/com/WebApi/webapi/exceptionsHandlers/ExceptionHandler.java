package com.WebApi.webapi.exceptionsHandlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(
            Exception exception, WebRequest request){

        ExceptionDetails details = new ExceptionDetails(new Date(),
                exception.getMessage(), request.getDescription(false));
        log.error("Global exception occurred: {}",exception.getMessage());
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(
            RuntimeException exception, WebRequest request){

        ExceptionDetails details = new ExceptionDetails(new Date(),
                exception.getMessage(), request.getDescription(false));
        log.error("RuntimeException occurred:{}",exception.getMessage());
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> handleServiceException(
            ServiceException exception, WebRequest request){

        ExceptionDetails details = new ExceptionDetails(new Date(),
                exception.getMessage(), request.getDescription(false));
        log.error("ServiceException occurred:{}",exception.getMessage());
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
