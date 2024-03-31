/**
 * 
 */
package edu.learntek.crud.model;

/**
 * @author ADMIN
 *
 */
public class MyError {
	private String errorCode;
	private String errorMessage;
	private String adviceMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getAdviceMessage() {
		return adviceMessage;
	}
	public void setAdviceMessage(String adviceMessage) {
		this.adviceMessage = adviceMessage;
	}
		
}
