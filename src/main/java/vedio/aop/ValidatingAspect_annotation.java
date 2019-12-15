package vedio.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidatingAspect_annotation {
	
	@Order(1)
	@Before("LoginingAspect_annotation.declareJoinPointExpression() ")
	public void validatingArgs(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		//在执行之前
		//判断args是否符合条件....
		System.out.println(Arrays.toString(args)+" pass the validation of method "+ methodName);
	}
}
