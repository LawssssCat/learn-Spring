package test.book.chapter2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring5.book.chapter2.MessageReader;

public class Demo_ClassPathXmlApplicationContext {
	public static void main(String[] args) {
		/*
		 *  spring - 依赖注入
		 *  setter 反射实现
		 */
		
		String resource = 
				"resource/book/h_applicationContext.xml"; 
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(resource); 
		MessageReader ms = ac.getBean("reader" , MessageReader.class);
		ms.reader();
	}
}
