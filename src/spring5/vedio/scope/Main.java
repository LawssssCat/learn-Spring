package spring5.vedio.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring5.vedio.beanrelation.Car;

public class Main {
	/**
	 * 单例
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("resource/vedio/beans-scope.xml") ;
		Car car = ac.getBean("car" , Car.class);
		Car car2 = ac.getBean("car" , Car.class);
		
		System.out.println(car == car2);
	}
}
