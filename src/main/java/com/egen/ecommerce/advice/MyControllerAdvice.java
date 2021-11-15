package com.egen.ecommerce.advice;

import com.egen.ecommerce.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleEmptyInputException(BusinessException exception){
//        BusinessException e=new BusinessException(exception.getErrorMessage(),exception,exception.getErrorCode());
        return new ResponseEntity<>(exception.getErrorMessage(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElement(NoSuchElementException exception){
        return new ResponseEntity<String>("Please check : No element with given value found",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArg(IllegalArgumentException exception){
        return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }



}
