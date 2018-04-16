package com.sacknibbles.logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sacknibbles.logger")
public class TestConfig {


	@Bean
	public TestMethodClass testMethodClass() {
		return new TestMethodClass();
	}
}
