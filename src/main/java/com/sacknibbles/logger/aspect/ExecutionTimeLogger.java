package com.sacknibbles.logger.aspect;

import java.time.Duration;
import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeLogger {
	
	private Logger LOGGER;// = LoggerFactory.getLogger(ExecutionTimeLogger.class);

	@Around("@annotation(com.sacknibbles.logger.LogExecutionTime)")
	public void executionTimeLogger(ProceedingJoinPoint pJointPoint) throws Throwable {
		LocalDateTime startDateTime = LocalDateTime.now();
		pJointPoint.proceed();
		LocalDateTime endDateTime = LocalDateTime.now();
		String methodName = pJointPoint.getSignature().getName();
		LOGGER = LoggerFactory.getLogger(pJointPoint.getSignature().getDeclaringType());
		LOGGER.info("[{}] execution time::{}",methodName, 
				Duration.between(startDateTime, endDateTime).toMillis());
	}
}
