package book.chapter4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class A implements InitializingBean , DisposableBean  {
	public A() {
		System.out.println("1. construct ... ");
	}
	
	private String a ;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		System.out.println("2. setting ... ");
		this.a = a;
	} 
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("3. postConstruct ... ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("4. afterPropertiesSet.afterPropertiesSet() ... ");
	}
	
	public void init() {
		System.out.println("5. init-method ... ");
	}
	public void doSomething() {
		System.out.println("-------------- do something ... ");
	}

	@PreDestroy
	public void PreDestroy() {
		System.out.println("1. PreDestroy ... ");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("2. DisposableBean.destroy() ... ");
	}
	
	public void destroyMethod() {
		System.out.println("3. destroy-method ... ");
	}
	
}
