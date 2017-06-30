package com.journaldev.spring.service.exception;

/**
 * Created by sergey on 30.6.17.
 */
public class ServiceFactoryException extends ServiceException {
    public ServiceFactoryException() {
    }

    public ServiceFactoryException(String message) {
        super(message);
    }

    public ServiceFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceFactoryException(Throwable cause) {
        super(cause);
    }
}
