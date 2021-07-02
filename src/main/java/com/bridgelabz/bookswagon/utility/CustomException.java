package com.bridgelabz.bookswagon.utility;

public class CustomException extends Exception {

    public enum ExceptionType{
        NULL_VALUE, Invalid_Data
    }

    private ExceptionType exceptionType;
    private String message;

    public CustomException(String message, ExceptionType exception) {
        this.exceptionType = exception;
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
