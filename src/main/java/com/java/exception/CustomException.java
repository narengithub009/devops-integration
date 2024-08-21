package com.java.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {

        super("Hello "+message);
        System.out.println("CustomException");
    }
}
