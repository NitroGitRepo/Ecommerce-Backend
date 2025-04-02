package com.ecommerce.productservice.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({Exception.class})
    public String exception(){
        return "Wait for something response or try again";
    }
}
