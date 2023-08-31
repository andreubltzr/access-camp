package com.example.springproject.validation;

import lombok.Getter;

import java.util.Map;

@Getter
public class ValidationException extends RuntimeException{

    private final Map<String, String> errors;

    public ValidationException(Map<String, String> errors) {
        this.errors = errors;
    }

}
