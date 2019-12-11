package spring5.test.book.chapter2;

import spring5.chapter2.helloworld.MessageProvider;
import spring5.chapter2.helloworld.MessageReader;
import spring5.chapter2.helloworld.MessageSupportFactory;

public class Demo_My_Factory {
	public static void main(String[] args) {
		System.out.println("工厂 - 打印 ...");
		
		MessageSupportFactory factory = 
				MessageSupportFactory.getInstance();
		MessageReader mr = factory.getMessagerReader();
		MessageProvider mp = factory.getMessageProvider();
		mr.setMessageProvider(mp);
		mr.reader();
	}
}
