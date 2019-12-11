package spring5.vedio.personandcar;

public class Car {
	private String brank ; 
	private double price ;
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
