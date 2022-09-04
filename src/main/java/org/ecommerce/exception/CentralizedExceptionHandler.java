package org.ecommerce.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler
	public final ResponseEntity<Object> cartCustomExceptionHandler(CartCustomException e,WebRequest request)
	{
		List<String> details=new ArrayList<>();
		details.add(e.getLocalizedMessage());
		return new ResponseEntity<Object>(details, HttpStatus.BAD_REQUEST);
				
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> productCustomExceptionHandler(ProductCustomException e,WebRequest request)
	{
		List<String> details=new ArrayList<>();
		details.add(e.getLocalizedMessage());
		return new ResponseEntity<Object>(details, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	public final ResponseEntity<Object> categoryNotFoundExceptionHandler(CategoryNotFoundException e,WebRequest request)
	{
		List<String> details=new ArrayList<>();
		details.add(e.getLocalizedMessage());
		return new ResponseEntity<Object>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleAllExceptionHandler(Exception e,WebRequest request)
	{
		List<String> details=new ArrayList<>();
		details.add(e.getLocalizedMessage());
		return new ResponseEntity<Object>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
