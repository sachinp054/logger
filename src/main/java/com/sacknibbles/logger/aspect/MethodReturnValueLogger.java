package com.sacknibbles.logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodReturnValueLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodReturnValueLogger.class);

	@After("@annotation(com.sacknibbles.logger.LogMethodArgument)")
	public void logArguments(JoinPoint joinPoint) {
		Object[] arguments = joinPoint.getArgs();
		LOGGER.info("Method return value::{}",arguments[0]);
	}

}
