package spring5.book.chapter3;

import org.springframework.stereotype.Component;

/*
 * provider99作为name值
 */
@Component("provider99")
public class HelloWroldMessageProvider_Component implements MessageProvider {

	public HelloWroldMessageProvider_Component() {
		System.out.println("new provider -- 99 ... ");
	}
	
	@Override
	public String getMassage() {
		return "Hello World! - 99";
	}

}
