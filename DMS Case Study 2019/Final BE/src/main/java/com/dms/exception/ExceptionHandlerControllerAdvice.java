package com.dms.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Class ExceptionHandlerControllerAdvice.
 */
@RestController
@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * User not found.
	 *
	 * @param exception the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(BADRequestException.class)
	public ResponseEntity<Object> userNotFound(BADRequestException exception, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false), HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	}
} 