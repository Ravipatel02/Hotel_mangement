package com.neebal.hotalservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neebal.hotalservice.payloder.ApiResponce;

@RestControllerAdvice
public class GlowbalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> handlerResourceNotFoundException( Exception ex){
		
		String message = ex.getMessage();
		ApiResponce responce = ApiResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponce>(responce , HttpStatus.NOT_FOUND);
		
	}

}
