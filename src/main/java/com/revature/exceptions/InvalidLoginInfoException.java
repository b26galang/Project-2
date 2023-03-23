package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidLoginInfoException extends Exception{
    public InvalidLoginInfoException() {
        super("Invalid Login Info");
    }
}
