package book.chapter3;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Demo_Constructor2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext xac = new GenericXmlApplicationContext(
				"book/h_applicationContext-constructor2.xml");
		 MessageProvider p = xac.getBean("provider123" , MessageProvider.class);
		 
		 System.out.println("-------------------");
		 
		 String massage = p.getMassage();
		 System.out.println(massage);
		
	}
}
