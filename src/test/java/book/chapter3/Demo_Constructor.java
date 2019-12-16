package book.chapter3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Demo_Constructor {
	public static void main(String[] args) {
		GenericXmlApplicationContext xac = 
				new GenericXmlApplicationContext(
				"book/h_applicationContext-constructor.xml");
		MessageReader r = xac.getBean("messageReader" , MessageReader.class);
		r.reader();
		
		System.out.println("---------------------");
		//scan 前 没有provider
		//MessageProvider p1 = xac.getBean("provider" , MessageProvider.class);
		MessageProvider p2 = xac.getBean("messageProvider" , MessageProvider.class);
		
	}
}
