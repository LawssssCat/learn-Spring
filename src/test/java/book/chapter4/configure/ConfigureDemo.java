package book.chapter4.configure;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigureDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("##############################");
		
		MessageReader r = (MessageReader) acx.getBean("messageReader");
		System.out.println("##############################");
		r.reader();
	}
}
