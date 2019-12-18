package vedio.factory;

import java.util.HashMap;
import java.util.Map;



/**
 * 静态工厂方法：
 * 直接调用某一个类的静态方法，就可以返回 Bean 的实例
 *
 */
public class StaticCarFactory {
	private static Map<String, Car> cars = new HashMap<>();
	static {
		String b1 = "Autio"  ; 
		cars.put(b1, new Car(b1, 3000)) ; 
		String b2 = "BMW"  ; 
		cars.put(b2, new Car(b2, 121213000)) ; 
	}
	public static Car getCar(String bank) {
		return cars.get(bank);
	}
}
