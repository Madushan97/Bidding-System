package com.nipuna.bidding.system.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StandardResponse<T> {
    private int status;
    private String message;
    private T data;

    public StandardResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
