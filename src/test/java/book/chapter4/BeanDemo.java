package book.chapter4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDemo {
	
	@Test
	public void testLoad$Close() {
		System.out.println("###### load  ##############");
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:book/chapter4/app-context-a.xml") ;
		gtx.refresh();
		
		System.out.println("###### getBean ############");
		A bean = gtx.getBean("a" , A.class);
		bean.doSomething();
		
		System.out.println("###### close  #############");
		gtx.close();
	}
	@Test
	public void testRegisterShutdownHook() {
		System.out.println("###### load  ##############");
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.registerShutdownHook();
		gtx.load("classpath:book/chapter4/app-context-a.xml") ;
		gtx.refresh();
		
		System.out.println("###### getBean ############");
		A bean = gtx.getBean("a" , A.class);
		bean.doSomething();
		
		System.out.println("###### close  #############");
	}
	
	@Test
	public void testDestroy() {
		System.out.println("###### load  ##############");
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:book/chapter4/app-context-a.xml") ;
		gtx.refresh();
		
		System.out.println("###### getBean ############");
		A bean = gtx.getBean("a" , A.class);
		bean.doSomething();
		
		System.out.println("###### close  #############");
		gtx.destroy();
	}
	
	
	@Test
	public void testClassPath() throws Exception {
		System.out.println("###### load  ##############");
		ApplicationContext gtx = 
				new ClassPathXmlApplicationContext("classpath:book/chapter4/app-context-a.xml");
		
		System.out.println("###### getBean ############");
		A bean = gtx.getBean("a" , A.class);
		bean.doSomething();
		System.out.println("###### close  #############");
	}
	
}
