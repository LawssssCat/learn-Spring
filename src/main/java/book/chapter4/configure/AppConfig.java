package book.chapter4.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import book.chapter4.configure.impl.MessageProviderImpl;
import book.chapter4.configure.impl.MessageReaderImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public MessageReader messageReader() {
		return new MessageReaderImpl() ; 
	}
	
	@Bean
	public MessageProvider messageProvider() {
		return new MessageProviderImpl() ; 
	}
}
