package com.lijinhuan.mq.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReturnAspect {

	@Pointcut(value="@annotation(com.lijinhuan.mq.annotation.ReturnValue)")
	public void pointCut() {}
	
	@AfterReturning(pointcut="pointCut()",returning="ret")
	public Map<String, Object> processReturnValue(JoinPoint jp,Object ret) throws Throwable{
		Map<String, Object> map = (Map<String, Object>) ret;
		map.put("code", "0000");
		map.put("message", "交易成功");
		return map;
	}
}
