package spring5.vedio.beanrelation;

public class Car {
	String brank ; 
	double price ;
	
	
	
	public Car() {
		System.out.println("Car Constructor... ");
	}
	public String getBrank() {
		return brank;
	}
	public void setBrank(String brank) {
		this.brank = brank;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [brank=" + brank + ", price=" + price + "]";
	} 
	
}
