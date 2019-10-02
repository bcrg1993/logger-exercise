package com.belatrix.logging.exception;

public class LoggerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LoggerException(String message) {
        super(message);
    }

	public LoggerException(String message, Throwable cause) {
        super(message, cause);
    }
}
