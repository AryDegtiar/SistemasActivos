package com.api.rest.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter @Getter
public class BusinessException extends RuntimeException {
    private String code;
    private HttpStatus httpStatus;

    public BusinessException(String code, HttpStatus httpStatus, String message){
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

}