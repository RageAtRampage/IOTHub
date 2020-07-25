package com.projectdata.IOTHub.exception;

public class InvalidException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidException(String message) {
		super(message);
	}
	
	public InvalidException(Throwable cause) {
		super(cause);
	}
	
	public InvalidException(String message, Throwable cause) {
		super(message, cause);
	}

}
