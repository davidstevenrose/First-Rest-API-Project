package com.shamus.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shamus.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

	// the Exception class provides a general exception to handle. To handle
	// specific exceptions, use that Exception class for the value.
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		
		String defErrMsg = "The error message was null";
		String emS = ex.getLocalizedMessage();
		System.out.println(emS);
		
		if (emS == null) emS = defErrMsg;
		
		ErrorMessage em = new ErrorMessage(new Date(), emS);
		
		return new ResponseEntity<>(em, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
	public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request) {
		
		String defErrMsg = "The error message was null";
		String emS = ex.getLocalizedMessage();
		System.out.println(emS);
		if (emS == null) emS = defErrMsg;
		
		ErrorMessage em = new ErrorMessage(new Date(), emS);
		
		return new ResponseEntity<>(em, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
