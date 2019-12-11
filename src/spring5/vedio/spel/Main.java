package spring5.vedio.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("resource/vedio/beans-spel.xml");
		Person p = ac.getBean("p1" , Person.class);
		System.out.println(p.toString());
	}
}
