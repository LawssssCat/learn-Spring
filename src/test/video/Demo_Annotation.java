package test.video;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring5.vedio.annotation.UserComponent;
import spring5.vedio.annotation.UserController;
import spring5.vedio.annotation.UserRepository;
import spring5.vedio.annotation.UserService;

public class Demo_Annotation {
	/*
	 + @Component:基本注解
	 + @Respository:持久层
	 + @Service:服务层
	 + @Controller:表现层
	 */
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"resource/vedio/beans-annotation.xml");
		System.out.println("--- 获得表现层 ---");
		UserController uc = ac.getBean("userController", UserController.class);
		uc.execute();
		
		System.out.println("--- 获得业务层 ---");
		UserService us = ac.getBean("userService" , UserService.class);
		us.add();
		
		System.out.println("--- 获得持久层 ---");
		UserRepository ur = ac.getBean("userRepository1" , UserRepository.class);
		ur.save();
		
		System.out.println("--- 获得组件 ---");
		UserComponent u = ac.getBean("userComponent" , UserComponent.class);
		System.out.println(u);
	}
}
