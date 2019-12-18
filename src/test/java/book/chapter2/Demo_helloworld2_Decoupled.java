package book.chapter2;

import book.chapter2.HelloWroldMessageProvider;
import book.chapter2.StandardOutMessageReader;

public class Demo_helloworld2_Decoupled {
	public static void main(String[] args) {
		StandardOutMessageReader mr = new StandardOutMessageReader();
		HelloWroldMessageProvider mp = new HelloWroldMessageProvider();
		mr.setMessageProvider(mp);
		mr.reader();
	}
}
