package vedio.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class LoginingAspect_xml {
	


	public void beforMethod( JoinPoint joinPoint ) {
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		//获取参数
		Object[] args = joinPoint.getArgs();
		System.out.println("The method "+ methodName+Arrays.toString(args) + " begin");
	}
	

	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The method "+ methodName+Arrays.toString(args) +" is end");
	}
	

	public void afterReturningMethod(JoinPoint jointPoint , Object result) {
		String methodName = jointPoint.getSignature().getName();
		Object[] args = jointPoint.getArgs();
		System.out.println("The result of "+methodName+Arrays.toString(args)+" is " + result);
	}

	public void afterThrowingMethod(JoinPoint joinPoint , Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs excetion:"+ex);
	}

}
