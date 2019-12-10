package spring5.chapter2.helloworld.helloworld5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring5.chapter2.helloworld.helloworld3.MessageReader;

public class Demo_helloworld_spring {
	public static void main(String[] args) {
		String resource = "spring5/chapter2/helloworld/helloworld5/applicationContext.xml" ; 
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource) ; 
		MessageReader ms = ac.getBean("reader" , MessageReader.class);
		ms.reader();
	}
}
