package com.sacknibbles.logger.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionLogger.class);
	
	@AfterThrowing(pointcut="@annotation(com.sacknibbles.logger.LogException)",throwing="ex")
	public void logException(Exception ex) {
		LOGGER.error("Exception occured:: ",ex);
	}
}
