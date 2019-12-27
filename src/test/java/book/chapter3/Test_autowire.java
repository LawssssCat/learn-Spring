package book.chapter3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_autowire {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAutowire_true() {
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/h_applicationContext-autowire.xml");
		gcx.refresh();
		
		System.out.println("-----------------------");
		System.out.println("byName");
		Object byName = gcx.getBean("byName");
		
		System.out.println("-----------------------");
		System.out.println("byType");
		Object byType = gcx.getBean("byType");
		
		System.out.println("-----------------------");
		System.out.println("constructor");
		Object constructor = gcx.getBean("constructor");
		
		gcx.close();
	}
	@Test
	public void testAutowire_false() {
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/h_applicationContext-autowire-error.xml");
		gcx.refresh();
		
		System.out.println("-----------------------");
		System.out.println("byName");
		Object byName = gcx.getBean("byName");
		
		System.out.println("-----------------------");
		System.out.println("byType");
		Object byType = gcx.getBean("byType");
		
		System.out.println("-----------------------");
		System.out.println("constructor");
		Object constructor = gcx.getBean("constructor");
		
		gcx.close();
	}

}
