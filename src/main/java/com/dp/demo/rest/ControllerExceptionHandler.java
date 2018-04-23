package com.dp.demo.rest;

import com.dp.demo.exception.InvalidSodaRequestException;
import com.dp.demo.exception.SodaNotFoundException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger log = LogManager.getLogger(ControllerExceptionHandler.class);

    @ResponseStatus(HttpStatus.NOT_FOUND) // 404
    @ExceptionHandler(SodaNotFoundException.class)
    public void handleNotFound(SodaNotFoundException ex) {
        log.error("Requested account not found");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(InvalidSodaRequestException.class)
    public void handleBadRequest(InvalidSodaRequestException ex) {
        log.error("Invalid account supplied in request");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler(Exception.class)
    public void handleGeneralError(Exception ex) {
        log.error("An error occurred processing request" + ex);
    }

}
