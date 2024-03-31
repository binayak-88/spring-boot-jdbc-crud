/**
 * 
 */
package edu.learntek.crud.exception;

/**
 * @author ADMIN
 *
 */
public class EmployeeAlreadyExistsException extends RuntimeException {
	private String msg;
	public EmployeeAlreadyExistsException(String msg) {
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}
}