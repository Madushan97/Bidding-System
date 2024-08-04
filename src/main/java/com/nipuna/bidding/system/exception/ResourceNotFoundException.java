package com.nipuna.bidding.system.exception;

import org.springframework.dao.DataAccessException;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String s, DataAccessException e) {

    }
}
