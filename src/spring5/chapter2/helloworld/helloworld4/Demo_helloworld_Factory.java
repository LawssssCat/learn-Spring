package spring5.chapter2.helloworld.helloworld4;

import spring5.chapter2.helloworld.helloworld3.MessageProvider;
import spring5.chapter2.helloworld.helloworld3.MessageReader;

public class Demo_helloworld_Factory {
	public static void main(String[] args) {
		MessageSupportFactory factory = MessageSupportFactory.getInstance();
		MessageReader mr = factory.getMessagerReader();
		MessageProvider mp = factory.getMessageProvider();
		mr.setMessageProvider(mp);
		mr.reader();
	}
}
