package com.example.max_market.CustomExceptions;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String message, Throwable err) {
        super(message,err);
    }

    public UserAlreadyExist(String message) {
        super(message);
    }
}
