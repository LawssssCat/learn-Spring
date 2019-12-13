package spring5.vedio.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorProxy {
	//要代理的对象
	private Calculator c = null ;
	public CalculatorProxy(Calculator c) {
		this.c = c ;
	}
	public Calculator getCalculatorProxy() {
		Calculator proxy = null ;
		//代理对象由每一个类加载器负责加载
		ClassLoader loader  = c.getClass().getClassLoader();
		Class[] interfaces = new Class[]{Calculator.class} ; 
		// 要执行的方法
		InvocationHandler h =  new InvocationHandler() {
			/**
			 * proxy:正在返回的那个代理对象（一般情况下，在invoke方法中都不使用该对象）
			 * method:正在被调用的方法
			 * args:调用方法时，传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) 
					throws Throwable {
				String methodName = method.getName();
				System.out.println("The method "+ methodName + " begin with "+ Arrays.toString(args));
				
				Object result = method.invoke(c , args); 
				
				System.out.println("result:"+ result);
				
				return result;
			}
		};
		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, h); 
		return proxy ;
	}
}
