package vedio.spel;

import java.util.List;

public class Person {
	String name ; 
	Car car ;
	Address addr; 
	
	/*
	 * spEL 判断
	 */
	String info  ;

	public String getName() {
		return name;
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

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", addr=" + addr + ", info=" + info + "]";
	} 
	
	
}
