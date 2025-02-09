package com.in28min.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointConfig {
	
	@Pointcut("execution(* com.in28min.learn_spring_aop.aopexample.business.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* com.in28min.learn_spring_aop.aopexample.data.*.*(..))")
	public void dataPackageConfig() {}
	
	@Pointcut("execution(* com.in28min.learn_spring_aop.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("bean(*Service*)")
	public void allPackageConfigUsingBeans() {}
	
	@Pointcut("@annotation(com.in28min.learn_spring_aop.aopexample.annotations.TrackTime)")
	public void trackTimeAnnotation() {}
}
