package com.ProductManagementSystemByGlobalException.AOP;

public class HandleError {

	private String statusCode;

	private String errorMsg;

	public HandleError(String statusCode, String errorMsg) {
		super();
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
	}

	public HandleError() {
		super();
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "HandleError [statusCode=" + statusCode + ", errorMsg=" + errorMsg + "]";
	}

}
