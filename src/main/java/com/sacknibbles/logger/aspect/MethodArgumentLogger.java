package com.sacknibbles.logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodArgumentLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodArgumentLogger.class);

	@Before("@annotation(com.sacknibbles.logger.LogMethodArgument)")
	public void logArguments(JoinPoint joinPoint) {
		Object[] arguments = joinPoint.getArgs();
		StringBuilder sb = new StringBuilder().append("[ ");
		for (Object obj : arguments) {
			sb.append(obj).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(" ]");

		LOGGER.info("Method Parameters::{}",sb.toString());
	}

}
