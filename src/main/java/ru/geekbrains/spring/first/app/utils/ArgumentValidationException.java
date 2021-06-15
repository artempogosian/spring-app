package ru.geekbrains.spring.first.app.utils;

public class ArgumentValidationException extends RuntimeException {
    public ArgumentValidationException(String message) {
        super(message);
    }
}