package com.lijinhuan.mq.exception;

import com.lijinhuan.mq.common.ErrorConstants;

public class MqException extends Exception{
	
	private String code;
	
	private String message;
	
	public MqException(ErrorConstants errorConstants) {
		this.code = errorConstants.getCode();
		this.message = errorConstants.getMessage();
	}

	public MqException(String code,String message,Throwable e) {
		super(message, e);
		this.code = code;
		this.message = message;
	}
	
	public MqException(String message,Throwable e) {
		super(message, e);
		this.code = ErrorConstants.E000001.getCode();
		this.message = message;
	}
	
	public MqException(ErrorConstants errorConstants,Throwable e) {
		super(errorConstants.getMessage(), e);
		this.code = errorConstants.getCode();
		this.message = errorConstants.getMessage();
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
