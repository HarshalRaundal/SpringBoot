package com.in28min.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Around("com.in28min.learn_spring_aop.aopexample.aspects.CommonPointConfig.businessAndDataPackageConfig()")
	@Around("com.in28min.learn_spring_aop.aopexample.aspects.CommonPointConfig.trackTimeAnnotation()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// Start Timer
		long startTimeMillis = System.currentTimeMillis();
		// Execute Method
		Object returnValue = proceedingJoinPoint.proceed();
		// Stop Timer
		long stopTimeMillis = System.currentTimeMillis();
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		logger.info("Around Aspect -- {} -- method executed in {} ms", proceedingJoinPoint,executionDuration);
		return returnValue;
	}
}
