package com.sacknibbles.logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestLogExceptionAnnotation {

	public static void main(String args[]) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfig.class);
		TestMethodClass t = ctx.getBean(TestMethodClass.class);		
		t.doProcessTwo("Sachin",1,123456);
	}
	
	
}
