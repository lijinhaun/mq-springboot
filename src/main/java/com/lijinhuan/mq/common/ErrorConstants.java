package com.lijinhuan.mq.common;

import java.net.Inet4Address;

public enum ErrorConstants {

	E000001("e00001","未知异常"),
	E000002("e00002","系统异常");
	
	private String code;
	
	private String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	ErrorConstants(String code,String message) {
		this.code = code;
		this.message = message;
	}
	
	public static String getErrorMessage(String code) {
		for (ErrorConstants ele : ErrorConstants.values()) {
			if (ele.getCode().equals(code)) {
				return ele.getMessage();
			}
		}
		return null;
	}

}
