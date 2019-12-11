package spring5.chapter3;

public class HelloWroldMessageProvider implements MessageProvider {

	@Override
	public String getMassage() {
		return "Hello World!";
	}

}
