package video;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vedio.factory.Car;

public class Demo_Factory {
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"/vedio/beans-factory.xml") ;
		
		System.out.println("--- 静态工厂：c1 ---");
		Car c1 = ac.getBean("c1" , Car.class);
		System.out.println(c1);
		
		System.out.println("--- 实例工厂：c2 ---");
		Car c2 = ac.getBean("c2" , Car.class);
		System.out.println(c2);
		
		System.out.println("--- FactoryBean：c3 ---");
		Car c3 = ac.getBean("c3" , Car.class) ; 
		System.out.println(c3);
		
	}
}
