package com.userservice.User.Service.exception;

public class InvalidTokenException extends Exception{

    public InvalidTokenException(String message){
        super(message);
    }
}
