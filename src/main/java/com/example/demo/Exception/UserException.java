package com.example.demo.Exception;

import jakarta.validation.ValidationException;

public class UserException extends ValidationException {
    public UserException(String message) {
        super(message);
    }
}
