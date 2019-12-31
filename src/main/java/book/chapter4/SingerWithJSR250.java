package book.chapter4;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerWithJSR250 {
	
	private static final String DEFAULT_NAME = "Eric Clapton" ; 
	
	private String name ; 
	private int age = Integer.MIN_VALUE  ; 
	
	
	
	
	public void setName(String name) {
		this.name = name;
	}




	public void setAge(int age) {
		this.age = age;
	}

	@Test
	public void testPostConstruct() {
		SingerWithJSR250 singerWithJSR250 = new SingerWithJSR250();
		System.out.println("finish ... ");
	}
	


	@PostConstruct
	public void init() {
		System.out.println("Initializing bean ... JSR250 ... ");
		
		if( name == null ) {
			System.out.println("Using default name ... JSR250 ... ");
			name = DEFAULT_NAME ; 
		}
		
		if(age == Integer.MIN_VALUE ) {
			throw new IllegalArgumentException(
					"You must set the age property of any beans of type "+ SingerWithJSR250.class) ; 
		}
		
		
	}




	@Override
	public String toString() {
		return "SingerWithJSR250 [name=" + name + ", age=" + age + "]";
	}
	
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/chapter4/app-context-annotation.xml");
		gcx.refresh();
		
		getBean("singerOne", gcx) ; 
		getBean("singerTwo", gcx) ; 
		getBean("singerThree", gcx) ; 
		
		gcx.close();
	}
	
	public static SingerWithJSR250 getBean(String beanName , ApplicationContext ctx) {
		try {
			SingerWithJSR250 bean = ctx.getBean(beanName , SingerWithJSR250.class);
			System.out.println(bean.toString());
			return bean ; 
		}catch (BeanCreationException e) {
			System.out.println("An error occured in bean configuration: "
					+ e.getMessage() );
			return null ; 
		}
	}
}
