package com.nipuna.bidding.system.exception;

public class ProductNameExistException extends RuntimeException {

    public ProductNameExistException() {
    }

    public ProductNameExistException (String message) {
        super(message);
    }
}
