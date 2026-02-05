package com.projeto.motivosparabeber.api.exception;

public class DescriptionTooLongException extends BusinessException {
    public DescriptionTooLongException(String message) {
        super(message);
    }
    public DescriptionTooLongException(String message, Throwable cause) {
        super(message, cause);
    }
}
