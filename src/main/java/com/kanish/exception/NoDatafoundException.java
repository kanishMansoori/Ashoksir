package com.kanish.exception;

import org.springframework.web.bind.annotation.RestController;


public class NoDatafoundException extends RuntimeException {
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDatafoundException() {
		
	}
	
	public  NoDatafoundException(String msg) {
		super(msg);
		
	}

}
