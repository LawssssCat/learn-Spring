package book.chapter3;

import org.springframework.context.support.GenericXmlApplicationContext;

import book.chapter3.annotation.Singer;

public class Demo_FieldInjection {
	public static void main(String[] args) {
		GenericXmlApplicationContext xac = new GenericXmlApplicationContext(
				);
		xac.load("book/h_applicationContext-annotation.xml");
		xac.refresh();
		Singer s = xac.getBean(Singer.class);
		s.sing();
	}
}
