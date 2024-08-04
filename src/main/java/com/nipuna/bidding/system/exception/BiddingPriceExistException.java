package com.nipuna.bidding.system.exception;

import org.springframework.dao.DataAccessException;

public class BiddingPriceExistException extends RuntimeException {

    public BiddingPriceExistException() {
    }

    public BiddingPriceExistException(String message) {
        super(message);
    }

    public BiddingPriceExistException(String s, DataAccessException e) {

    }
}
