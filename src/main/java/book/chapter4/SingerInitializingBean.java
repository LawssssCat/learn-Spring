package book.chapter4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerInitializingBean 
implements InitializingBean {
	
	public SingerInitializingBean() {
		System.out.println("singer() ...");
	}
	public SingerInitializingBean(String  name ) {
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
	}
	@Override
	public String toString() {
		return "Singer [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/chapter4/h_application-initializingBean.xml");
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
	private static SingerInitializingBean getBean(String name, GenericXmlApplicationContext gcx) {
		
		try {
			SingerInitializingBean singer = gcx.getBean(name , SingerInitializingBean.class) ;
			System.out.println(singer);
			return singer ; 
		} catch (BeanCreationException e) {
			System.out.println("An error occured in bean configuration "+e.getMessage());
			return null;
		}
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing bean");
		
		if(name == null ) {
			System.out.println("Using default name");
			name = DEFAULT_NAME ; 
		}
		
		if(age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"You must set the age property of any beans of type "+ SingerInitializingBean.class) ; 
		}
	}
	
	
	
	
}
