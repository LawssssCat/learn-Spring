package spring5.chapter2.helloworld.helloworld3;

import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWroldMessageProvider implements MessageProvider {

	@Override
	public String getMassage() {
		return "Hello World!";
	}

}
