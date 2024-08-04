package com.nipuna.bidding.system.exception;

import org.springframework.dao.DataAccessException;

public class CustomGenericException extends RuntimeException {

    public CustomGenericException() {
    }

    public CustomGenericException (String message) {
        super(message);
    }

    public CustomGenericException(String s, DataAccessException e) {

    }
}
