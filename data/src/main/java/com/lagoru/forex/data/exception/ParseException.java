package com.lagoru.forex.data.exception;

/**
 * Created by lagoru on 27.11.16.
 */

public class ParseException extends Exception {

    private final Exception exception;

    public ParseException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public String getErrorMessage() {
        String message = "";
        if (this.exception != null) {
            message = this.exception.getMessage();
        }
        return message;
    }
}