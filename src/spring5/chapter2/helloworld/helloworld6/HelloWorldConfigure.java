package spring5.chapter2.helloworld.helloworld6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5.chapter2.helloworld.helloworld3.HelloWroldMessageProvider;
import spring5.chapter2.helloworld.helloworld3.MessageProvider;
import spring5.chapter2.helloworld.helloworld3.MessageReader;
import spring5.chapter2.helloworld.helloworld3.StandardOutMessageReader;

@Configuration
public class HelloWorldConfigure {
	@Bean
	public MessageProvider provider() {
		return new HelloWroldMessageProvider() ; 
	}
	
	@Bean
	public MessageReader reader() {
		MessageReader reader = new StandardOutMessageReader(); 
		reader.setMessageProvider(provider());
		return reader ; 
	}
}
