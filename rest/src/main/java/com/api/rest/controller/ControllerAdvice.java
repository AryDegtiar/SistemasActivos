package com.api.rest.controller;

import com.api.rest.DTO.ErrorDTO;
import com.api.rest.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorDTO> businessExceptionHandler(BusinessException e) {
        ErrorDTO errorDTO = ErrorDTO.builder().status_code(e.getCode()).status(e.getHttpStatus().getReasonPhrase()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorDTO, e.getHttpStatus());
    }

}
