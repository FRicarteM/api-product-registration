package com.fabtec.apiproductregistration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 5761138175846798832L;

	public BadRequestException(String exception) {
		super(exception);		
	}
}
