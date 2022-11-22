package com.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value= {NoHandlerFoundException.class}) 
	public String exception404 (Exception exception) {
		return "error/error404";
	}
}
