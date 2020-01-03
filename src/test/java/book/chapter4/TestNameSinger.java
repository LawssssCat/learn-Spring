package book.chapter4;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestNameSinger {

	@Test
	public void testNameSinger() {
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:book/chapter4/app-context-xml.xml");
		gtx.refresh();
		
		System.out.println("---------------------");
		NamedSinger bean = gtx.getBean(NamedSinger.class);
		System.out.println("---------------------");
		bean.sing();
		System.out.println("---------------------");
		
		gtx.close();
	}
	
	
	@Test
	public void testPropertyEditorExample() throws ClassNotFoundException {
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:book/chapter4/app-config-02.xml");
		gtx.refresh();
		
		CustomEditorExample bean = gtx.getBean("p" , CustomEditorExample.class);
		FullName name = bean.getName();
		System.out.println(name);
	}
		
}
