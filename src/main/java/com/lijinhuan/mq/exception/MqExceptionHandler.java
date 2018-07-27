package com.lijinhuan.mq.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lijinhuan.mq.common.ErrorConstants;

@ControllerAdvice
public class MqExceptionHandler {

	/**
	 * 捕获异常，按统一格式返回数据
	 * @return
	 */
	@ExceptionHandler(value = MqException.class)
	@ResponseBody
	public Map<String, Object> errorHandler(MqException exception){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", exception.getCode());
		map.put("message", exception.getMessage());
		return map;
	}
	
	
	/**
	 * 捕获异常，按统一格式返回数据
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Map<String, Object> exceptionHandler(Exception exception){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", ErrorConstants.E000001.getCode());
		map.put("message", exception.getMessage());
		return map;
	}
}
