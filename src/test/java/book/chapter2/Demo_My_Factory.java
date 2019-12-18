package book.chapter2;

import book.chapter2.MessageProvider;
import book.chapter2.MessageReader;
import book.chapter2.MessageSupportFactory;

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
