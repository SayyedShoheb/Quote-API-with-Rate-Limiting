package com.quotegenerator.exception;

public class QuoteGeneratorException extends RuntimeException{

	private String exceptionmessage;
	
	public QuoteGeneratorException() {
		
	}
	public QuoteGeneratorException(String exceptionmessage) {
		super();
		this.exceptionmessage=exceptionmessage;
	}
	public String getExceptionmessage() {
		return exceptionmessage;
	}

	public void setExceptionmessage(String exceptionmessage) {
		this.exceptionmessage = exceptionmessage;
	}

	@Override
	public String toString() {
		return "QuoteGeneratorException [exceptionmessage=" + exceptionmessage + "]";
	}
}
