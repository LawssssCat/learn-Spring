package test.book.chapter2;

import spring5.book.chapter2.HelloWroldMessageProvider;
import spring5.book.chapter2.StandardOutMessageReader;

public class Demo_helloworld2_Decoupled {
	public static void main(String[] args) {
		StandardOutMessageReader mr = new StandardOutMessageReader();
		HelloWroldMessageProvider mp = new HelloWroldMessageProvider();
		mr.setMessageProvider(mp);
		mr.reader();
	}
}
