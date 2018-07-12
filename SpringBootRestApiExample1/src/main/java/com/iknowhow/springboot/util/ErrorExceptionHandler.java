package com.iknowhow.springboot.util;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	  public final void handleUserNotFoundException(HttpServletResponse response) throws IOException{
	    response.sendError(HttpStatus.NOT_FOUND.value(), "User Not Found.");
	  } 
	


}