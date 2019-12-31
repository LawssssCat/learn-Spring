package book.chapter4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDemoHook {
	

	@Test
	public void testHookBean() {
		System.out.println("###### load  ##############");
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:book/chapter4/app-context-xml-hook.xml") ;
		gtx.refresh();
		
		System.out.println("###### getBean ############");
		A bean = gtx.getBean("a" , A.class);
		bean.doSomething();
		
		System.out.println("###### close  #############");
	}
	

	
}
