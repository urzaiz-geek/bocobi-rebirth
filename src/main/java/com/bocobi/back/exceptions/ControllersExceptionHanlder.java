package com.bocobi.back.exceptions;

import java.util.Date;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllersExceptionHanlder {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		ErrorMessage message = ErrorMessage.builder()
				.statusCode(HttpStatus.NOT_FOUND.value())
				.date(new Date())
				.description(request.getDescription(false))
				.message(ex.getMessage())
				.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalErrorException(Exception ex, WebRequest request){
		ErrorMessage message = ErrorMessage.builder()
				.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.date(new Date())
				.description(request.getDescription(false))
				.message(ex.getMessage())
				.build();
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
	
	}
}
