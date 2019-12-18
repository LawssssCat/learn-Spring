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

@Aspect
@Component
public class LoginingAspect_annotation {
	
	/*
	 * 定义一个方法，用于声明切入点表达式，
	 * 使用 @Pointcut 来声明切入点表达式
	 * 后面的其他执行通知直接使用方法名来引用当前的切入点表达式。
	 */
	@Pointcut("execution(public int vedio.proxy.Calculator.*(..) )")
	public void declareJoinPointExpression() {
		//一般的，该方法中不再需要添加其他代码。
	}
	
	/**
	 * 在方法执行之前执行的一段代码
	 */
	@Order(2)
	@Before("declareJoinPointExpression() ")
	public void beforMethod( JoinPoint joinPoint ) {
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		//获取参数
		Object[] args = joinPoint.getArgs();
		System.out.println("The method "+ methodName+Arrays.toString(args) + " begin");
	}
	
	
	//后置通知：在目标方法执行后(无论是否发生异常)，执行的通知
	//注意：这里不能获得结果，结果在返回其他通知里面
	/**
	 * 无论被代理方法是否执行，之后一定执行！ 
	 */
	@After("declareJoinPointExpression() ")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The method "+ methodName+Arrays.toString(args) +" is end");
	}
	
	/**
	 * 在方法正常结束时，执行的代码
	 * 返回通知时可以访问到方法的返回值的！ 
	 */
	@AfterReturning(value ="declareJoinPointExpression() ", 
			returning = "result")
	public void afterReturningMethod(JoinPoint jointPoint , Object result) {
		String methodName = jointPoint.getSignature().getName();
		Object[] args = jointPoint.getArgs();
		System.out.println("The result of "+methodName+Arrays.toString(args)+" is " + result);
	}
	
	/**
	 * 在目标方法出现异常时会执行的代码
	 * 可以访问到异常对象
	 * 且可以执行在出现特定异常时在执行通知代码
	 */
	@AfterThrowing( value = "declareJoinPointExpression() " , 
			throwing = "ex") 
	public void afterThrowingMethod(JoinPoint joinPoint , Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs excetion:"+ex);
	}
	
//	/**
//	 * 环绕通知需要携带 ProceedingJoinPoint 类型的参数，
//	 * 环绕通知类似于动态代理的全过程： 
//	 * ProcedingJoinPoint 类型的参数可以决定是否执行目标的方法
//	 */
//	@Around(value = "execution(public int vedio.proxy.Calculator.*(..) )")
//	public Object aroundMthod(ProceedingJoinPoint pjd) {
//		Object result = null ;
//		String methodName = pjd.getSignature().getName();
//		Object[] args = pjd.getArgs();
//		
//		//前置通知
//		System.out.println("The method "+ methodName+Arrays.toString(args) + " begin");
//		
//		try {
//			//执行目标方法
//			result = pjd.proceed(args);
//			//后置通知
//			System.out.println("The method "+ methodName+Arrays.toString(args) +" is end");
//			//返回通知
//			System.out.println("The result of "+methodName+Arrays.toString(args)+" is " + result);
//		} catch (Throwable e) {
//			//后置通知
//			System.out.println("The method "+ methodName+Arrays.toString(args) +" is end");
//			//异常通知
//			System.out.println("The method "+methodName+" occurs excetion:"+e);
//		}finally {
//		}
//		
//		return result; 
//	}
}
