package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Around("execution(* com.example.demo..controller.*Controller.*(..)) or execution(* com.example.demo..service.*Impl.*(..)) or execution(* com.example.demo..mapper.*Mapper.*(..))")
	public Object printLog(ProceedingJoinPoint jointPoint) throws Throwable {
		
		String type = "";
		String name = jointPoint.getSignature().getDeclaringTypeName();
		
		if (name.contains("Controller") == true) {
			type = "Controller ===> ";
		} else if (name.contains("Service") == true) {
			type = "ServiceImpl ===> ";
		} else if (name.contains("Mapper") == true) {
			type = "Mapper ===> ";
		}

		//logger.debug(type + name + "." + jointPoint.getSignature().getName() + "()");
		System.out.println(type + name + "." + jointPoint.getSignature().getName() + "()");
		return jointPoint.proceed();
	}
}
