package spring5.book.chapter2;

public class HelloWroldMessageProvider implements MessageProvider {

	@Override
	public String getMassage() {
		return "Hello World!";
	}

}
