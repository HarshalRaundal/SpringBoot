package com.in28min.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//configuration class
//AOP configuration

//advise -- combination of Advise and PointCut
@Configuration
@Aspect
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	//PointCut - When?
	//all calls in class in specific package
	//execution(* PACKAGE.*.*(..))
	//          ^ return value 
	// execution(* com.in28min.learn_spring_aop.aopexample.business.*.*(..))
	//@Pointcut("execution(* com.in28min.learn_spring_aop.aopexample.business.*.*(..))")
	@Before("com.in28min.learn_spring_aop.aopexample.aspects.CommonPointConfig.allPackageConfigUsingBeans()")
	public void logMethodCallBefore(JoinPoint joinPoint) {
		//log method
		//Login - What? // Advise -- 
		logger.info("Logging in Aspect -- Before Aspect -- {} is called with arguments {}", joinPoint, joinPoint.getArgs()); // WHAT
		
	}
	
	// both successful execution and throwing error/exception
	@After("com.in28min.learn_spring_aop.aopexample.aspects.CommonPointConfig.businessPackageConfig()")
	public void logMethodCallAfter(JoinPoint joinPoint) {
		//log method
		//Login - What? // Advise -- 
		logger.info("Logging in Aspect -- After Aspect -- {} is called with arguments {}", joinPoint, joinPoint.getArgs()); // WHAT
		
	}
	@AfterReturning(
	pointcut = "com.in28min.learn_spring_aop.aopexample.aspects.CommonPointConfig.dataPackageConfig()",
	returning = "resultValue")
	public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue) {
		//log method
		//Login - What? // Advise -- 
		logger.info("Logging in Aspect -- After Returning Aspect -- {} with resultValue {}", joinPoint, resultValue); // WHAT
		
	}
	@AfterThrowing(
			pointcut = "com.in28min.learn_spring_aop.aopexample.aspects.CommonPointConfig.businessAndDataPackageConfig()",
			throwing = "exception")
	public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
		//log method
		//Login - What? // Advise -- 
		logger.info("Logging in Aspect -- After Throwing Aspect -- {} has thrown exception {}", joinPoint, exception); // WHAT
		
	}
}
