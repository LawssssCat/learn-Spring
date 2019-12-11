package spring5.test.book.chapter2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring5.chapter2.helloworld.HelloWorldConfigure;
import spring5.chapter2.helloworld.MessageReader;

public class Demo_AnnotationConfigApplicationContext {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ApplicationContext ac = 
				new AnnotationConfigApplicationContext(
						HelloWorldConfigure.class);
		
		System.out.println("---------------------");
		
		/*
		 * reader123 是 Configure 的Bean 修饰的方法名 
		 *  方法名在Context内被视作name值
		 */
		MessageReader ms = ac.getBean("reader123", MessageReader.class);
		ms.reader();
		
	}
}
