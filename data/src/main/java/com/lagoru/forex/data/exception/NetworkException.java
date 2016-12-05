package com.lagoru.forex.data.exception;

/**
 * Created by lagoru on 27.11.16.
 */

public class NetworkException extends Exception {

    public NetworkException() {
        super();
    }

    public NetworkException(final String message) {
        super(message);
    }

    public NetworkException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NetworkException(final Throwable cause) {
        super(cause);
    }
}
