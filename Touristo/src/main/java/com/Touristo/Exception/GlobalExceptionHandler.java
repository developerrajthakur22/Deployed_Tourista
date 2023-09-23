package com.Touristo.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> allExceptionHandler(Exception ex, WebRequest we){
		 ErrorDetails ed = new ErrorDetails();
		 ed.setTimestamp(LocalDateTime.now());
		 ed.setMessage(ex.getMessage());
		 ed.setDescription(we.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> notFoundExceptionHandler(NotFoundException ex, WebRequest we){
		ErrorDetails ed = new ErrorDetails();
		 ed.setTimestamp(LocalDateTime.now());
		 ed.setMessage(ex.getMessage());
		 ed.setDescription(we.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TouristoException.class)
	public ResponseEntity<ErrorDetails> TouristoExceptionHandler(TouristoException ex, WebRequest we){
		ErrorDetails ed = new ErrorDetails();
		 ed.setTimestamp(LocalDateTime.now());
		 ed.setMessage(ex.getMessage());
		 ed.setDescription(we.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
}