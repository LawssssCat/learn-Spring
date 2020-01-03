package book.chapter4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/chapter4/app-context-xml2.xml");
		gcx.refresh();
		
		MessageDigester messageDigester = gcx.getBean("digester" , MessageDigester.class);
		messageDigester.messageDigest("hello world!");
		
	}
}
