package spring5.chapter2.helloworld.helloworld3;

public class Demo_helloworld_Decoupled {
	public static void main(String[] args) {
		StandardOutMessageReader mr = new StandardOutMessageReader();
		HelloWroldMessageProvider mp = new HelloWroldMessageProvider();
		mr.setMessageProvider(mp);
		mr.reader();
	}
}
