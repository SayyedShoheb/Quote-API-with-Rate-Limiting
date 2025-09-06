package com.quotegenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//It is used to specify the class is used to handle the exceptions
@RestControllerAdvice
public class QuoteGeneratorExceptionHandler {

	//It is used to specify which class exception can be handled
	@ExceptionHandler(QuoteGeneratorException.class)
	public ResponseEntity<String> handlingQuoteGeneratorException(QuoteGeneratorException qge){
		return new ResponseEntity<String>(qge.getExceptionmessage(),HttpStatus.TOO_MANY_REQUESTS);
	}
}
