package com.neebal.user.service.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neebal.user.service.UserService.payload.ApiResponce;

@RestControllerAdvice
public class GlowbalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> handlerResourceNotFoundExceptin(Exception ex){
		
		String msg = ex.getMessage();
		ApiResponce responce = ApiResponce.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<ApiResponce>(responce , HttpStatus.NOT_FOUND);
		
	}
	
	

}
