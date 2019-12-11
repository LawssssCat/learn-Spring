package spring5.chapter2.helloworld.helloworld3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("reader")
public class StandardOutMessageReader implements MessageReader {
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
	
	@Autowired
	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.provider=provider ; 
	}

	@Autowired
	@Override
	public MessageProvider getMessageProvider() {
		return this.provider;
	}

}
