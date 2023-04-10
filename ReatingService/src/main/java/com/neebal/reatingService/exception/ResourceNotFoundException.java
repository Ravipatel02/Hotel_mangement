package com.neebal.reatingService.exception;

public class ResourceNotFoundException  extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("Resurce not found !");
	}
	
	public ResourceNotFoundException(String msg) {
		
		super(msg);
		
	}

}
