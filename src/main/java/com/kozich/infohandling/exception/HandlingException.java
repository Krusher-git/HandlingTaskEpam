package com.kozich.infohandling.exception;

public class HandlingException extends Exception {
    public HandlingException() {
        super();
    }

    public HandlingException(String message) {
        super(message);
    }

    public HandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandlingException(Throwable cause) {
        super(cause);
    }
}
