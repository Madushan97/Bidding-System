package com.nipuna.bidding.system.exception;

import org.springframework.dao.DataAccessException;

public class CustomDatabaseException extends RuntimeException{

    public CustomDatabaseException() {
    }

    public CustomDatabaseException (String message) {
        super(message);
    }

    public CustomDatabaseException(String s, DataAccessException e) {

    }
}
