package com.neebal.hotalservice.payloder;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class ApiResponce {
	
	private String message;
	private boolean success;
	
	private HttpStatus status;

}
