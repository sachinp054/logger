package com.sacknibbles.logger;

import com.sacknibbles.logger.LogException;
import com.sacknibbles.logger.LogExecutionTime;
import com.sacknibbles.logger.LogMethodArgument;
import com.sacknibbles.logger.LogMethodReturnValue;

public class TestMethodClass {

	@LogException
	public void doProcessOne() {
		throw new IllegalArgumentException();
	}
	
	@LogMethodReturnValue
	@LogExecutionTime
	@LogMethodArgument
	public String doProcessTwo(String s, int a, long b) {
		return "Hello:: "+s;
	}
	
}
