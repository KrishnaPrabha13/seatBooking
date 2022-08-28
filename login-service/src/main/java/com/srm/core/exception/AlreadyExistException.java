package com.srm.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.IM_USED)
public class AlreadyExistException extends RuntimeException{
	
	public AlreadyExistException(String message) {
		super(message);
	}
}
