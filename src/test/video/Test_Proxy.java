package test.video;

import org.junit.Test;

import spring5.vedio.proxy.Calculator;
import spring5.vedio.proxy.CalculatorImp;
import spring5.vedio.proxy.CalculatorProxy;

public class Test_Proxy {
	@Test
	public void test01() {
		
		Calculator c = new CalculatorImp();
		Calculator proxy = new CalculatorProxy(c).getCalculatorProxy();
		
		int a = 4 ; 
		int b = 2 ; 
		
		int result = 0 ;
		
		result = proxy.add(a, b);
		result = proxy.add(result, a); 
		result = proxy.div(a, b) ; //2
		
		result = proxy.mul(a, b); //8
	}
}
