package video;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vedio.spel.Person;

public class Demo_spEL {
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("/vedio/beans-spel.xml");
		Person p = ac.getBean("p1" , Person.class);
		System.out.println(p.toString());
	}
}
