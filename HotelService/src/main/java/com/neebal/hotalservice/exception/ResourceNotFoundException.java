package com.neebal.hotalservice.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("Resurce not found !");
	}
	
	public ResourceNotFoundException(String msg) {
		
		super(msg);
		
	}

}
