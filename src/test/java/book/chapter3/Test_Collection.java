package book.chapter3;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import book.chapter3.collection.CollectionInjuection;

public class Test_Collection {
	private GenericXmlApplicationContext gtx = null ; 
	{
		gtx = new GenericXmlApplicationContext() ; 
		gtx.load("classpath:book/h_collection.xml");
		gtx.refresh();
	}
	
	@Test
	public void testXmlInjection_Collection() {
		CollectionInjuection c = gtx.getBean(CollectionInjuection.class);
		c.displayInfo();
	}
}
