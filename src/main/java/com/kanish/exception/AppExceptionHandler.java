package com.kanish.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = NoDatafoundException.class)
	public ResponseEntity<String> Handlerexception(NoDatafoundException exp){
		
		String exmsg=exp.getMessage();
		return new ResponseEntity<>(exmsg,HttpStatus.BAD_REQUEST);
		
	}

}
