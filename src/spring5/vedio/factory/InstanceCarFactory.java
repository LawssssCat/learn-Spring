package spring5.vedio.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂 
 *
 */
public class InstanceCarFactory {
	Map<String,Car> map = null; 
	
	public InstanceCarFactory() {
		map = new HashMap<String, Car>() ;
		String b1  ="Autio" ; 
		map.put(b1, new Car(b1, 111111111)) ; 
		
		String b2 = "BMW" ; 
		map.put(b2, new Car(b2, 28888888)) ; 
	}
	
	public Car getCar(String bank) {
		return map.get(bank); 
	}
}
