package book.chapter4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:book/chapter4/app-context-messagedigest.xml");
		gtx.refresh();
		
		MessageDigester messageDigester = gtx.getBean(MessageDigester.class);
		messageDigester.messageDigest("Hello World!");
		
	}
}
