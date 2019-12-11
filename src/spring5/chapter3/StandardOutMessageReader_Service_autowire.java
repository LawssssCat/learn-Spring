package spring5.chapter3;

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
	
	//TODO 为什么会到old？
	@Autowired
	@Override
	public void setMessageProvider(MessageProvider provider) {
		System.out.println("set provider ...autowire...");
		this.provider=provider ; 
	}

	@Override
	public MessageProvider getMessageProvider() {
		return provider;
	}

}
