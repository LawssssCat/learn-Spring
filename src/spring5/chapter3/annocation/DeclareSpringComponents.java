package spring5.chapter3.annocation;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring5.chapter2.helloworld.helloworld3.MessageReader;

public class DeclareSpringComponents {
	public static void main(String[] args) {
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext();
		gxac.load("classpath:resource/book/chapter3-autowired.xml");
		
		//没有refresh，会抛出IllegalStateException
		//GenericXmlApplicationContext@7eda2dbb has not been refreshed yet
		gxac.refresh();
		
		MessageReader mr = gxac.getBean("reader" , MessageReader.class);
		mr.reader();
	}
}
