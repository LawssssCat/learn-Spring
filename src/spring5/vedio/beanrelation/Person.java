package spring5.vedio.beanrelation;

import java.util.List;

public class Person {
	String name ; 
	Car car ;
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
}
