package spring5.vedio.beanrelation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	/*
	 * 必要声明 示例
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring5/vedio/beanrelation/beans-relation.xml");
		Person p = ac.getBean("person" , Person.class );
		System.out.println(p.toString());
	}
}
