package book;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_AA {
	@Test
	public void test01() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:book/h_aa.xml");
		
		System.out.println("----------------------");
		
		String[] beanNamesForType = ctx.getBeanNamesForType(Aa.class);
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
		
		System.out.println("----------------------");
		//Object bean = ctx.getBean("book.AA#0");
		//System.out.println(bean);
		
		System.out.println("success");
	}
}
