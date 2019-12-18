package video;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vedio.proxy.Calculator;

public class Test_AOP_xml {
	@Test
	public void test01() {
		ClassPathXmlApplicationContext pac = 
				new ClassPathXmlApplicationContext("vedio/beans-aop-xml.xml");
		Calculator c = pac.getBean("calculator" , Calculator.class);
		int a = 4 ; 
		int b = 2 ; 
		int result ; 
		result = c.add(a, b) ;
		result = c.sub(a, b);
		result = c.div(a, 0);
	}
}
