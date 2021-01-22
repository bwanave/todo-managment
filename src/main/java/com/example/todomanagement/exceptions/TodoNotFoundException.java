package com.example.todomanagement.exceptions;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(String message) {
        super(message);
    }
}
