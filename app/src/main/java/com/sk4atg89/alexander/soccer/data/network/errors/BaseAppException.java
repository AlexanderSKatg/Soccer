package com.sk4atg89.alexander.soccer.data.network.errors;

public class BaseAppException extends Throwable {

    private static final String MESSAGE = "MAIN_EXCEPTION";

    public BaseAppException() {
        super(MESSAGE);
    }

    public BaseAppException(String message) {
        super(message);
    }

    public BaseAppException(Throwable throwable) {
        this(MESSAGE, throwable);
    }

    public BaseAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
