package test.video;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring5.vedio.Car;

public class Demo_ApplicationContext_Scope {
	/**
	 * 单例
	 */
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("resource/vedio/beans-scope.xml") ;
		Car car = ac.getBean("car" , Car.class);
		Car car2 = ac.getBean("car" , Car.class);
		
		System.out.println(car == car2);
	}
}
