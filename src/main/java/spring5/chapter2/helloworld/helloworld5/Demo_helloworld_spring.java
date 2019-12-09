package spring5.chapter2.helloworld.helloworld5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo_helloworld_spring {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("./main/resources/app-context.xml") ; 
	}
}
