package com.srm.core.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LoginServiceControllerAdvice extends ResponseEntityExceptionHandler{

	
//	@ExceptionHandler(IllegalArgumentException.class)
//	public ResponseEntity<String> handleEmptyInput(IllegalArgumentException ex){
//		return new ResponseEntity<String> ("Input can't be empty", HttpStatus.BAD_REQUEST);
//	}
	
//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException ex){
//		return new ResponseEntity<String> ("No  value is present in Database ", HttpStatus.BAD_REQUEST);
//	}
}
