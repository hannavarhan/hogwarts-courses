package com.epam.hogwarts.exception;

public class EnumParseException extends Exception {
    public EnumParseException() {
        super();
    }

    public EnumParseException(String message) {
        super(message);
    }

    public EnumParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnumParseException(Throwable cause) {
        super(cause);
    }
}
