package vedio.spel;

public class Car {
	String brank ; 
	double price ;
	
	/*
	 *  spEL 运算 
	 */
	double perimiter ;

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

	public double getPerimiter() {
		return perimiter;
	}

	public void setPerimiter(double perimiter) {
		this.perimiter = perimiter;
	}

	@Override
	public String toString() {
		return "Car [brank=" + brank + ", price=" + price + ", perimiter=" + perimiter + "]";
	}

}
