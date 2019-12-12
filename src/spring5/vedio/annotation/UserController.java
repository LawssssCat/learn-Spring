package spring5.vedio.annotation;

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
@Controller
public class UserController {
	
	public void execute() {
		System.out.println("UserController execute...表现层...");
	}
	
}
