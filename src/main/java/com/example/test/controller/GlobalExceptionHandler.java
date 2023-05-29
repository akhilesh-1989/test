package com.example.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = StudentNotFountException.class)
	public ResponseEntity<Object> studentNotFoundExceptionHandler(){
		
		return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
	}
}
