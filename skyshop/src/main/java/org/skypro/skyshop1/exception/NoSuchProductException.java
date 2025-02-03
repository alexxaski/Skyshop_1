package org.skypro.skyshop1.exception;

public class NoSuchProductException extends RuntimeException {


    public NoSuchProductException(String message) {
        super(message);
    }

    public NoSuchProductException(String message, Throwable cause) {
        super(message, cause);
    }
}

