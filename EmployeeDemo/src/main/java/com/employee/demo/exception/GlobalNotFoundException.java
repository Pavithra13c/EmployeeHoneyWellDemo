package com.employee.demo.exception;

public class GlobalNotFoundException extends RuntimeException {

	public GlobalNotFoundException() {
		super();
	}

	public GlobalNotFoundException(String message) {
		super(message);
	}

}
