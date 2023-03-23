package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IdDoesNotExistException extends Exception {
   public IdDoesNotExistException() {
       super("ID Does not exist");
   }

}
