/**
 * 
 */
package edu.learntek.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ADMIN
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {
	
	private String msg;

	public EmployeeNotFoundException(String msg) {
		super(msg);
		this.msg=msg;
	}
	
	public String getExceptionMessage() {
		return msg;
	}
}
