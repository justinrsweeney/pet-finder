package com.jsweeney.petfinder.pets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissingPetReportNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MissingPetReportNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(MissingPetReportNotFoundException ex) {
        return ex.getMessage();
    }
}
