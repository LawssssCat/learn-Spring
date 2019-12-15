package spring5.book.chapter3;

import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service("reader99")
public class StandardOutMessageReader_Service_autowire implements MessageReader {
	public StandardOutMessageReader_Service_autowire() {
		System.out.println("new reader -- 99 ...");
	}
	
	
	private MessageProvider provider ; 
	
	@Override
	public void reader() {
		if(provider==null) {
			throw new RuntimeException(
			"You must set the property messageProvider of class:"
			+provider.getClass().getName());
		}
		System.out.println(provider.getMassage());
	}
	
	/*
	 * 如果有多个相同类型参数
	 * Autowired根据形参名选择
	 */
	@Autowired()
	@Override
	public void setMessageProvider(MessageProvider provider99) {
		System.out.println("set provider ...autowire..."+ provider99.getClass().getName());
		this.provider=provider99 ; 
	}

	@Override
	public MessageProvider getMessageProvider() {
		return provider;
	}

}
