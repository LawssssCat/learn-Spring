package video;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vedio.Person;

public class Demo_BeanRelation {
	/*
	 * 必要声明 示例
	 */
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("/vedio/beans-relation.xml");
		Person p = ac.getBean("person" , Person.class );
		System.out.println(p.toString());
	}
}
