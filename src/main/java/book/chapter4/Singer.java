package book.chapter4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Singer {
	public Singer() {
		System.out.println("singer() ...");
	}
	public Singer(String  name ) {
		this.name = name ;
	}
	

	private static final String DEFAULT_NAME = "Eric Clapton" ; 
	
	private String name ; 
	private int age = Integer.MIN_VALUE ; 
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void init() {
		System.out.println("Initializing bean");
		
		if(name == null ) {
			System.out.println("Using default name");
			name = DEFAULT_NAME ; 
		}
		
		if(age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"You must set the age property of any beans of type "+ Singer.class) ; 
		}
		
	}
	@Override
	public String toString() {
		return "Singer [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/chapter4/h_application-init-method.xml");
		gcx.refresh();
		
		System.out.println("----------------------");
		getBean("singerOne" , gcx ) ; 
		System.out.println("----------------------");
		getBean("singerTwo" , gcx ) ; 
		System.out.println("----------------------");
		getBean("singerThree" , gcx ) ; 
		System.out.println("----------------------");
		
		gcx.close();
	}
	public  static Singer getBean(String name, ApplicationContext gcx) {
		
		try {
			Singer singer = gcx.getBean(name , Singer.class) ;
			System.out.println(singer);
			return singer ; 
		} catch (BeanCreationException e) {
			System.out.println("An error occured in bean configuration "+e.getMessage());
			return null;
		}
	}
	
	
	
	
}
