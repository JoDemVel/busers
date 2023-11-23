package com.jdve.busers.exceptions;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message){
        super(message);
    }
}
