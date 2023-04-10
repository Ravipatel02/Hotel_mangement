package com.neebal.user.service.UserService.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	
	public ResourceNotFoundException() {
		super("Resource Not found exception !");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
