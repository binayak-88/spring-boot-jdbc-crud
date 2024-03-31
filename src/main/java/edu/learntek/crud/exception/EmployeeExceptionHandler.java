/**
 * 
 */
package edu.learntek.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.learntek.crud.model.MyError;

/**
 * @author ADMIN
 *
 */
@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<MyError> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException e){
		MyError error = new MyError();
		error.setErrorCode("400");
		error.setErrorMessage(e.getMessage());
		error.setAdviceMessage("Please use different eid....");
		
		ResponseEntity<MyError> responseEntity = new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<MyError> handleEmployeeNotFoundException(EmployeeNotFoundException e){
		MyError error = new MyError();
		error.setErrorCode("400");
		error.setErrorMessage(e.getMessage());
		error.setAdviceMessage("Please use existing  eid....");
		
		ResponseEntity<MyError> responseEntity = new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
}
