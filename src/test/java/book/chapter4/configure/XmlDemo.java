package book.chapter4.configure;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import book.chapter4.configure.impl.MessageReaderImpl;

public class XmlDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:book/chapter4/configure/app-context-reader$provider.xml");
		System.out.println("###############################");
		MessageReaderImpl r = (MessageReaderImpl) ctx.getBean("reader");
		System.out.println("###############################");
		r.reader();
	}
}
