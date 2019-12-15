package video;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vedio.proxy.Calculator;

public class Test_AOP_annotation {
	@Test
	public void test01() {
		ClassPathXmlApplicationContext pac = 
				new ClassPathXmlApplicationContext("vedio/beans-aop.xml");
		Calculator c = pac.getBean("calculator" , Calculator.class);
		int a = 4 ; 
		int b = 2 ; 
		int result =0 ; 
		
		result = c.add(a, b) ;
		
		result = c.sub(a, b);
		
		//异常
		result = c.div(a, 0);
		
	}
}
