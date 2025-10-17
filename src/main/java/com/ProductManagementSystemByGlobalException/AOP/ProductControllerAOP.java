package com.ProductManagementSystemByGlobalException.AOP;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ProductManagementSystemByGlobalException.Exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductControllerAOP {

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<HandleError> handlingProductException(ProductNotFoundException pne) {
		return new ResponseEntity<HandleError>(new HandleError("404 page not found", pne.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<HandleError> handlingInternalException(Exception ex) {
		return new ResponseEntity<HandleError>(new HandleError("500 Internal server error", ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
