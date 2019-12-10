package spring5.chapter2.helloworld.helloworld6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring5.chapter2.helloworld.helloworld3.MessageReader;

public class Demo_HelloWorld_annotation {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class<HelloWorldConfigure> clazz = 
				HelloWorldConfigure.class ;
		ApplicationContext ac = 
				new AnnotationConfigApplicationContext(clazz);
		MessageReader ms = ac.getBean("reader", MessageReader.class);
		ms.reader();
		
	}
}
