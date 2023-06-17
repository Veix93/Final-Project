package com.sda.Management.exceptions;

import java.io.Serial;

public class FishNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1;

    public FishNotFoundException(String message) {
        super(message);
    }
}
