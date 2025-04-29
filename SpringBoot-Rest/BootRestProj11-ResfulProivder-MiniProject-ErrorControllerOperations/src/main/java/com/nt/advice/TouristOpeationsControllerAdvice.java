//TouristOpeationsControllerAdvice.java
package com.nt.advice;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.error.ErrorDetails;
import com.nt.error.TouristNotFoundException;

@RestControllerAdvice
public class TouristOpeationsControllerAdvice {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFoundException(TouristNotFoundException tnfe){
		  ErrorDetails details=new ErrorDetails(LocalDateTime.now(), tnfe.getMessage(), "404- Tourist not found");
		  return  new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e){
		  ErrorDetails details=new ErrorDetails(LocalDateTime.now(), e.getMessage(), "500- Server erorr");
		  return  new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
