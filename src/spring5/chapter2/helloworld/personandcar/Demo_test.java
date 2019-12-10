package spring5.chapter2.helloworld.personandcar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo_test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring5/chapter2/helloworld/helloworld/configure.xml");
		Person p1 = ac.getBean("P1" , Person.class);
		System.out.println(p1.toString());
	}
}
