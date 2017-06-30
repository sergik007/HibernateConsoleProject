package com.journaldev.spring.controller.exception;

/**
 * Created by sergey on 30.6.17.
 */
public class ControllerException extends Exception {
    public ControllerException() {
        super();
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }
}
