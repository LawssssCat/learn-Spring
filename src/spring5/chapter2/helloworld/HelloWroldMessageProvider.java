package spring5.chapter2.helloworld;

public class HelloWroldMessageProvider implements MessageProvider {

	@Override
	public String getMassage() {
		return "Hello World!";
	}

}
