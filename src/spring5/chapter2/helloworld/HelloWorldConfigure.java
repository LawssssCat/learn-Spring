package spring5.chapter2.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfigure {
	@Bean
	public MessageProvider provider() {
		System.out.println("new provider ... ");
		return new HelloWroldMessageProvider() ; 
	} 
	
	@Bean
	public MessageReader reader123() {
		System.out.println("new reader ... ");
		MessageReader reader = new StandardOutMessageReader(); 
		reader.setMessageProvider(provider());
		return reader ; 
	}
	
	/*
	 * 没有 Bean 注解。将不被执行
	 */
	public void otherMethod() {
		System.out.println("do other ...");
	}
}
