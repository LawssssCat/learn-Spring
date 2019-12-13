package spring5.vedio.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * 
 * ACID
 * A - 原子性
 * C - 一致性
 * I - 隔离性
 * D - 持久性
 */
/**
 * 表现层
 */
@Controller("userController")
public class UserController {
	
	@Autowired
	UserService userService = null ;
	
	public void execute() {
		userService.add();
		System.out.println(this.getClass().getName()+" execute...表现层...");
	}
	
}
