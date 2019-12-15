package book.chapter3.old;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import book.chapter3.HelloWroldMessageProvider;
import book.chapter3.MessageProvider;
import book.chapter3.MessageReader;
import book.chapter3.StandardOutMessageReader;


@Configuration
public class HelloWorldConfigure {
	
	/*
	 * 先有 "new provider ... "
	 * 后有 "new reader ..."
	 */
	@Bean(name = "reader99")
	public MessageReader reader() {
		System.out.println("new reader ... ");
		MessageReader reader = new StandardOutMessageReader(); 
		/*
		 * 这里进行手动 - 自动组装
		 */
		reader.setMessageProvider(provider());
		return reader ; 
	}
	
	/*
	 * 不定义name，自动指定方法名作为name值
	 */
	@Bean
	public MessageProvider provider() {
		System.out.println("new provider ... ");
		return new HelloWroldMessageProvider() ; 
	} 
	
	/*
	 * 没有 Bean 注解。将不被执行
	 */
	public void otherMethod() {
		System.out.println("do other ...");
	}
}
