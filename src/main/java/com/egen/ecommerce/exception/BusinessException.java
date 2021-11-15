package com.egen.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BusinessException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public BusinessException(){}

    public BusinessException(String errorMessage, String errorCode) {
       this.errorMessage=errorMessage;
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
